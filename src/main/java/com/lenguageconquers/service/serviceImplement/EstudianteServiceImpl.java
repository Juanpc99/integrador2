package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.EstudianteDAO;
import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteDAO estudianteDAO;
/**
    @Override
    public Estudiante registrar(Estudiante estudiante) {
        return estudianteDAO.save(estudiante);
    }

    @Override
    public Estudiante modificar(Estudiante estudiante) {
        return estudianteDAO.save(estudiante);
    }

    @Override
    public void eliminar(int id) {
       // estudianteDAO.delete(id);
    }

    @Override
    public Estudiante listarId(int id) {
        return null;
        //return estudianteDAO.findOne(id);
    }

    @Override
    public List<Estudiante> listar() {
        return estudianteDAO.findAll();
    }

    @Override
    public Estudiante buscar(String nombreEstudiante) {
        return estudianteDAO.findOneByNombreEstudiante(nombreEstudiante);
    }
    */
}
