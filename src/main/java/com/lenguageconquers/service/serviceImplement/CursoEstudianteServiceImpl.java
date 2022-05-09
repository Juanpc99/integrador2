package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.*;
import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;
import com.lenguageconquers.service.CursoEstudianteService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Scope("singleton")
@Service
public class CursoEstudianteServiceImpl implements CursoEstudianteService {

    @Autowired
    private CursoEstudianteDAO cursoEstudianteDAO;

    @Autowired
    private CursoDAO cursoDAO;

    @Autowired
    private EstudianteDAO estudianteDAO;

    @Autowired
    private MisionDAO misionDAO;

    @Autowired
    private RetosDAO retosDAO;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public String matricularCurso2(Long idEstudiante, Long idCurso, String password) throws Exception {
        CursoEstudiante cursoEstudiante = new CursoEstudiante();
        Curso curso = cursoDAO.findById(idCurso).get();
        String contraseña = encoder.encode(password);
        Estudiante estudiante = estudianteDAO.findById(idEstudiante).get();
        if(!encoder.matches(password, curso.getPassword())){
            throw new Exception("La contraseña no es valida");
        }
        if(estudianteDAO.findById(idEstudiante).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del estudiante valido");
        }
        if(cursoDAO.findById(idCurso).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del curso valido");
        }
        if(idEstudiante.toString().length() >3){
            throw new Exception("El id del estudiante es muy largo, no valido");
        }
        if(idCurso.toString().length() >3){
            throw new Exception("El id del curso es muy largo, no es valido");
        }
        if(cursoDAO.findByIdEstudianteCursoConProgramaIgual(idCurso, estudiante.getPrograma().getIdPrograma()).size() == 0){
            throw new Exception("No puede matricular un curso que no este asignado a su programa");
        }

        if(!Validaciones.isNumeric(idCurso.toString())){
            throw new Exception("EL id curso solo permite numeros");
        }
        if(!Validaciones.isNumeric(idEstudiante.toString())){
            throw new Exception("EL id estudiante solo permite numeros");
        }
        cursoEstudiante.setEstudiante(estudianteDAO.findById(idEstudiante).get());
        cursoEstudiante.setCurso(cursoDAO.findById(idCurso).get());
        cursoEstudiante.setNivel(1L);
        cursoEstudiante.setPuntaje_estuduante(0.0);
        cursoEstudianteDAO.save(cursoEstudiante);
        return "Se ha matriculado correctamente";
    }
    @Override
    public String matricularCurso(CursoEstudianteDTO cursoEstudianteDTO) throws Exception {

        CursoEstudiante cursoEstudiante = new CursoEstudiante();


        cursoEstudiante.setEstudiante(estudianteDAO.findById(cursoEstudianteDTO.getIdEstudiante()).get());
        cursoEstudiante.setCurso(cursoDAO.findById(cursoEstudianteDTO.getIdCurso()).get());
        cursoEstudianteDAO.save(cursoEstudiante);
        return "Sematriculo exitosamente el curso";
    }

    @Override
    public void eliminarMatricula(Long idEstudiante,Long idCursoEstudiante) throws Exception {
       if(idEstudiante == null && idCursoEstudiante == null){
           throw new Exception("Debe ingresar el id del estudiante y del curso estudiante");
       }
       if(!cursoEstudianteDAO.existsById(idCursoEstudiante)){
           throw new Exception("No se encontro el curso estudiante");
       }

        cursoEstudianteDAO.deleteById(idCursoEstudiante);
    }

    @Override
    public List<CursoEstudiante> listaCursosMatriculados(Long idEstudiante, Long idCurso) {

        //cursoEstudianteDAO.findAll();
        return cursoEstudianteDAO.findAll();
    }

    @Override
    public List<CursoEstudianteDTO> listarPorIdEstudiante(Long idEstudiante) throws Exception {
        List<CursoEstudiante> cursoEstudianteList = cursoEstudianteDAO.findByIdEstudiante(idEstudiante);
        List<CursoEstudianteDTO> cursoEstudianteDTOList= new ArrayList<>();
        for (CursoEstudiante cursoEstudiante: cursoEstudianteList) {
            CursoEstudianteDTO cursoEstudianteDTO = new CursoEstudianteDTO();
            cursoEstudianteDTO.setIdCursoEstudiante(cursoEstudiante.getIdCursoEstudiante());
            cursoEstudianteDTO.setIdEstudiante(cursoEstudiante.getEstudiante().getIdEstudiante());
            cursoEstudianteDTO.setIdCurso(cursoEstudiante.getCurso().getIdCurso());
            cursoEstudianteDTO.setNivel(cursoEstudiante.getNivel());
            cursoEstudianteDTO.setPuntaje_estudiante(cursoEstudiante.getPuntaje_estuduante());
            cursoEstudianteDTOList.add(cursoEstudianteDTO);
        }

        return cursoEstudianteDTOList;
    }

    @Override
    public String subirDeNivel(Long nivel, Long idEstudiante, Long idCurso) throws Exception {
        Double totalRetos = cursoEstudianteDAO.totalRetos(nivel, idEstudiante, idCurso);
        Double retosTerminados = cursoEstudianteDAO.retosTerminados(nivel, idEstudiante, idCurso);
        Double resultado = totalRetos/retosTerminados;
        String mensaje = null;
        CursoEstudiante cursoEstudiante =cursoEstudianteDAO.findaByIdEstudianteAndIdCUrso(idEstudiante,idCurso);
        if(cursoEstudiante.getNivel() != nivel){
            throw new Exception("El nivel no es valido");
        }
        if(resultado == 1 && cursoEstudiante.getNivel() == nivel){
            cursoEstudiante.setNivel(cursoEstudiante.getNivel() + 1);
            cursoEstudianteDAO.save(cursoEstudiante);

            mensaje = "Usted ha alcanzado el nivel " + (cursoEstudiante.getNivel());
        }else{
            mensaje = "Usted no ha completado todos los retos del nivel";
        }
        return mensaje;
    }

    @Override
    public List<CursoEstudianteDTO> listarRanking(Long idCurso) throws Exception {
        List<CursoEstudiante> cursoEstudianteList = cursoEstudianteDAO.ranking(idCurso);
        List<CursoEstudianteDTO> cursoEstudianteDTOList= new ArrayList<>();
        if(idCurso == null || idCurso <=0){
            throw new Exception("Debe ingresar un id de curso valido");
        }
        for (CursoEstudiante cursoEstudiante: cursoEstudianteList) {
            CursoEstudianteDTO cursoEstudianteDTO = new CursoEstudianteDTO();
            cursoEstudianteDTO.setIdCursoEstudiante(cursoEstudiante.getIdCursoEstudiante());
            cursoEstudianteDTO.setIdEstudiante(cursoEstudiante.getEstudiante().getIdEstudiante());
            cursoEstudianteDTO.setIdCurso(cursoEstudiante.getCurso().getIdCurso());
            cursoEstudianteDTO.setPuntaje_estudiante(cursoEstudiante.getPuntaje_estuduante());
            cursoEstudianteDTO.setNivel(cursoEstudiante.getNivel());
            cursoEstudianteDTOList.add(cursoEstudianteDTO);
        }
        if(cursoEstudianteDTOList.isEmpty()){
            throw new Exception("No se encontraron estudiantes en ese curso, por lo tanto no hay ranking");
        }
        if(cursoEstudianteDTOList.size() <2){
            throw new Exception("No hay suficientes estudiantes para realizar un ranking ");
        }

        return cursoEstudianteDTOList;
    }

    @Override
    public Double notaFinal(Long idEstudiante, Long idCurso) throws Exception {
        Integer totalMisiones = misionDAO.findAll().size();
        Integer misionesTerminadas = cursoEstudianteDAO.misionesTerminadasPorEstudiante(idEstudiante).size();
        Date fechaFinal = cursoDAO.findById(idCurso).get().getFinCurso();
        Date fechaActual = new Date();
        if(totalMisiones != misionesTerminadas){
            throw new Exception("El estudiante no ha terminado el curso");
        }
        Integer totalRetos = retosDAO.estudiantesPorCurso(idCurso).size();
        Double puntaje = cursoEstudianteDAO.findaByIdEstudianteAndIdCUrso(idEstudiante,idCurso).getPuntaje_estuduante();
        Double total  = ((puntaje * 2)/100)/totalRetos;
        if(total >= 5.0){
            return 5.0;
        }
        return total;

    }

    @Override
    public Integer nivelEstudiante(Long idReto, Long idEstudiante) {
        Integer nivel = 0;
        nivel = cursoEstudianteDAO.nivelEstudiante(idReto,idEstudiante);
        return nivel;
    }



    @Override
    public List<CursoEstudiante> listaCursosMatriculadosPorEstudiate(Long idEstudiante) throws Exception {
        CursoEstudianteDTO cursoEstudianteDTO = new CursoEstudianteDTO();
        if(Validaciones.isIdNull(idEstudiante)){
            throw new Exception("Debe ingresar el id del estudiante");
        }
        List<CursoEstudiante> lista = (List<CursoEstudiante>) cursoEstudianteDAO.findById(cursoEstudianteDTO.getIdEstudiante()).get();
        if(lista.isEmpty()){
            throw new Exception("El estudiante no tiene aun matriculado ningun curso");
        }
        return lista;
    }

}
