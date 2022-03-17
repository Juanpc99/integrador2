package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.NivelAcademicoDAO;
import com.lenguageconquers.model.NivelAcademico;
import com.lenguageconquers.service.NivelAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class NivelAcademicoServiceImpl implements NivelAcademicoService {

    @Autowired
    private NivelAcademicoDAO nivelAcademicoDAO;

    @Override
    public NivelAcademico registrar(NivelAcademico nivelAcademico) {
        return nivelAcademicoDAO.save(nivelAcademico);
    }

    @Override
    public NivelAcademico modificar(NivelAcademico nivelAcademico) {
        return nivelAcademicoDAO.save(nivelAcademico);
    }

    @Override
    public void eliminar(int id) {
        //nivelAcademicoDAO.delete(id);
    }

    @Override
    public NivelAcademico listarId(int id) {
        return null;
        //return nivelAcademicoDAO.findOne(id);
    }

    @Override
    public List<NivelAcademico> listar() {
        return nivelAcademicoDAO.findAll();
    }
}
