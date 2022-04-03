package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.CursoDAO;
import com.lenguageconquers.dao.CursoEstudianteDAO;
import com.lenguageconquers.dao.EstudianteDAO;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;
import com.lenguageconquers.service.CursoEstudianteService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public String matricularCurso(CursoEstudianteDTO cursoEstudianteDTO) throws Exception {

        CursoEstudiante cursoEstudiante = new CursoEstudiante();
        if(estudianteDAO.findById(cursoEstudianteDTO.getIdEstudiante()).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del estudiante valido");
        }
        if(cursoDAO.findById(cursoEstudianteDTO.getIdCurso()).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del curso valido");
        }
        if(cursoEstudianteDTO.getIdEstudiante().toString().length() >3){
            throw new Exception("El id del estudiante es muy largo, no valido");
        }
        if(cursoEstudianteDTO.getIdCurso().toString().length() >3){
            throw new Exception("El id del curso es muy largo, no es valido");
        }
        if(cursoDAO.findByIdEstudianteCursoConProgramaIgual(cursoEstudianteDTO.getIdEstudiante()).size() == 0){
            throw new Exception("No puede matricular un curso que no pertenezca a su programa");
        }
        if(Validaciones.isNumeric(cursoEstudianteDTO.getIdCurso().toString())){
            throw new Exception("EL id curso solo permite numeros");
        }
        if(Validaciones.isNumeric(cursoEstudianteDTO.getIdEstudiante().toString())){
            throw new Exception("EL id estudiante solo permite numeros");
        }

        cursoEstudiante.setEstudiante(estudianteDAO.findById(cursoEstudianteDTO.getIdEstudiante()).get());
        cursoEstudiante.setCurso(cursoDAO.findById(cursoEstudianteDTO.getIdCurso()).get());
        cursoEstudianteDAO.save(cursoEstudiante);
        return "Sematriculo exitosamente el curso";
    }

    @Override
    public void eliminarMatricula(Long idEstudiante,Long idCursoEstudiante) {
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
            cursoEstudianteDTOList.add(cursoEstudianteDTO);
        }

        return cursoEstudianteDTOList;
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


/**


    @Override
    public CursoEstudiante listarId(int id) {
        return null;
        //return cursoEstudianteDAO.findOne(id);
    }

    @Override
    public List<CursoEstudiante> listar() {
        return cursoEstudianteDAO.findAll();
    }
    */
}
