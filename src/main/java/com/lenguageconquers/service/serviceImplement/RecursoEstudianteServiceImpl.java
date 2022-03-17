package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.RecursoEstudianteDAO;
import com.lenguageconquers.model.RecursoEstudiante;
import com.lenguageconquers.service.RecursoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class RecursoEstudianteServiceImpl implements RecursoEstudianteService {

    @Autowired
    private RecursoEstudianteDAO recursoEstudianteDAO;

    @Override
    public RecursoEstudiante registrar(RecursoEstudiante recursoEstudiante) {
        return recursoEstudianteDAO.save(recursoEstudiante);
    }

    @Override
    public RecursoEstudiante modificar(RecursoEstudiante recursoEstudiante) {
        return recursoEstudianteDAO.save(recursoEstudiante);
    }

    @Override
    public void eliminar(int id) {
        //recursoEstudianteDAO.delete(id);
    }

    @Override
    public RecursoEstudiante listarId(int id) {
        return null;
        //return recursoEstudianteDAO.findOne(id);
    }

    @Override
    public List<RecursoEstudiante> listar() {
        return recursoEstudianteDAO.findAll();
    }
}
