package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.CursoDAO;
import com.lenguageconquers.model.Curso;
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
    public Optional<Curso> findById(Long idCurso) {
        return cursoDAO.findById(idCurso);
    }


}
