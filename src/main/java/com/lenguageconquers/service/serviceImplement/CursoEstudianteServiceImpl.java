package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.CursoDAO;
import com.lenguageconquers.dao.CursoEstudianteDAO;
import com.lenguageconquers.dao.EstudianteDAO;
import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;
import com.lenguageconquers.service.CursoEstudianteService;
import com.lenguageconquers.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class CursoEstudianteServiceImpl implements CursoEstudianteService {

    @Autowired
    private CursoEstudianteDAO cursoEstudianteDAO;

    @Autowired
    private CursoService cursoService;

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
            return "Se matriculo exitosamente el curso";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public void eliminarMatricula(Long idCursoEstudiante) {
        cursoEstudianteDAO.deleteById(idCursoEstudiante);
    }

    @Override
    public List<CursoEstudiante> listaCursosMatriculados() {
        return cursoEstudianteDAO.findAll();
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
