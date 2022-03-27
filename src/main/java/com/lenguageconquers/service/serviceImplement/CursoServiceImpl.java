package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.CursoDAO;
import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.dto.CursoDTO;
import com.lenguageconquers.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoDAO cursoDAO;
/**
    @Override
    public Curso registrar(Curso curso) {
        return cursoDAO.save(curso);
    }

    @Override
    public Curso modificar(Curso curso) {
        return cursoDAO.save(curso);
    }

    @Override
    public void eliminar(int id) {
        //cursoDAO.delete(id);
    }

    @Override
    public Curso listarId(int id) {
        return null;
       // return cursoDAO.findOne(id);
    }

    @Override
    public List<Curso> listar() {
        return cursoDAO.findAll();
    }
*/
    @Override
    public List<Curso> findByPassword(String password) {
        return cursoDAO.findByPassword(password);
    }

    @Override
    public List<Curso> findByProfesor(Integer idProfesor) {
        //return cursoDAO.findByProfesor(idProfesor);
        return null;
    }

    @Override
    public String registrarCurso(CursoDTO cursoDTO) {
        try{
            Curso curso = new Curso();
            curso.setNombreCurso(cursoDTO.getNombreCurso());
            curso.setInicioCurso(cursoDTO.getInicioCurso());
            curso.setFinCurso(cursoDTO.getFinCurso());
            curso.setCantidadEstudiantes(curso.getCantidadEstudiantes());
            curso.setPassword(cursoDTO.getPassword());
            curso.setProfesor(cursoDAO.findById(cursoDTO.getIdProfesor()).get());
            curso.setEstado(cursoDAO.findById(cursoDTO.getIdEstado()).get());
            curso.setPrograma(cursoDAO.findById(cursoDTO.getIdPrograma()).get());
            cursoDAO.save(curso);
            return "Se creo exitosamente el curso";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Curso> listaCursos() {
        return cursoDAO.findAll();
    }
/*
    @Override
    public CursoDTO findByIdCurso(Long idCurso) {
        CursoDTO cursoDTO = new CursoDTO();
        Curso curso = cursoDAO.findById(idCurso).get();
        cursoDTO.setIdCurso(curso.getIdCurso());
        cursoDTO.setInicioCurso(curso.getInicioCurso());
        cursoDTO.setFinCurso(curso.getFinCurso());
        cursoDTO.setNombreCurso(curso.getNombreCurso());
        cursoDTO.setCantidadEstudiantes(curso.getCantidadEstudiantes());
        cursoDTO.setIdEstado(curso.getEstado().getIdEstado());
        cursoDTO.setIdPrograma(curso.getPrograma().getIdPrograma());
        cursoDTO.setPassword(curso.getPassword());

        return cursoDTO;
    }

 */


}
