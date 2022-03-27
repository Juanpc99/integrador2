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
    public String matricularCurso(CursoEstudianteDTO cursoEstudianteDTO){

        try{
            CursoEstudiante cursoEstudiante = new CursoEstudiante();
            cursoEstudiante.setEstudiante(estudianteDAO.findById(cursoEstudianteDTO.getIdEstudiante()).get());
            cursoEstudiante.setCurso(cursoDAO.findById(cursoEstudianteDTO.getIdCurso()).get());
            cursoEstudianteDAO.save(cursoEstudiante);
            return "Sematriculo exitosamente el curso";
        }catch (Exception e){
            return e.getMessage();
        }
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
