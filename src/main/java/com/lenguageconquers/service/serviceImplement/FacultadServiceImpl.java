package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.FacultadDAO;
import com.lenguageconquers.model.Facultad;
import com.lenguageconquers.service.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class FacultadServiceImpl implements FacultadService {

    @Autowired
    private FacultadDAO facultadDAO;

/**
    @Override
    public Facultad registrar(Facultad facultad) {
        return facultadDAO.save(facultad);
    }

    @Override
    public Facultad modificar(Facultad facultad) {
        return facultadDAO.save(facultad);
    }

    @Override
    public void eliminar(int id) {
        //facultadDAO.delete(id);
    }

    @Override
    public Facultad listarId(int id) {
        return null;
        //return facultadDAO.findOne(id);
    }

    @Override
    public List<Facultad> listar() {
        return facultadDAO.findAll();
    }
    */
}
