package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.NivelAcademicoEstudianteDAO;
import com.lenguageconquers.model.NivelAcademicoEstudiante;
import com.lenguageconquers.service.NivelAcademicoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class NivelAcademicoEstudianteServiceImpl implements NivelAcademicoEstudianteService {

    @Autowired
    private NivelAcademicoEstudianteDAO nivelAcademicoEstudianteDAO;
/**
    @Override
    public NivelAcademicoEstudiante registrar(NivelAcademicoEstudiante nivelAcademicoEstudiante) {
        return nivelAcademicoEstudianteDAO.save(nivelAcademicoEstudiante);
    }

    @Override
    public NivelAcademicoEstudiante modificar(NivelAcademicoEstudiante nivelAcademicoEstudiante) {
        return nivelAcademicoEstudianteDAO.save(nivelAcademicoEstudiante);
    }

    @Override
    public void eliminar(int id) {
        //nivelAcademicoEstudianteDAO.delete(id);
    }

    @Override
    public NivelAcademicoEstudiante listarId(int id) {
        return null;
        //return nivelAcademicoEstudianteDAO.findOne(id);
    }

    @Override
    public List<NivelAcademicoEstudiante> listar() {
        return nivelAcademicoEstudianteDAO.findAll();
    }
    */
}
