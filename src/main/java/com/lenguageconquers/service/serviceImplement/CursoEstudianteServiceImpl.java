package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.CursoEstudianteDAO;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.service.CursoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class CursoEstudianteServiceImpl implements CursoEstudianteService {
/**
    @Autowired
    private CursoEstudianteDAO cursoEstudianteDAO;

    @Override
    public CursoEstudiante registrar(CursoEstudiante cursoEstudiante) {
        return cursoEstudianteDAO.save(cursoEstudiante);
    }

    @Override
    public CursoEstudiante modificar(CursoEstudiante cursoEstudiante) {
        return cursoEstudianteDAO.save(cursoEstudiante);
    }
    //TODO: VERIFICAR METODO DE ELIMINAR
    @Override
    public void eliminar(int id) {
        //cursoEstudianteDAO.delete(id);
    }

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
