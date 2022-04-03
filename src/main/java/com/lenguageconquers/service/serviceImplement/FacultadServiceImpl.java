package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.FacultadDAO;
import com.lenguageconquers.model.Facultad;
import com.lenguageconquers.model.dto.FacultadDTO;
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

    @Override
    public List<Facultad> listarFacultades() {
        return facultadDAO.findAll();
    }

    @Override
    public String registrarFacultad(FacultadDTO facultadDTO) throws Exception {
        Facultad facultad = new Facultad();
        if(facultadDTO.getNombreFacultad() == null || facultadDTO.getNombreFacultad().trim().equals("")){
            throw new Exception("Debe ingresar un nombre de facultad");
        }
        if(facultadDTO.getNombreFacultad().length()>50){
            throw new Exception("El nombre de la facultad es muy largo");
        }
        facultad.setNombreFacultad(facultadDTO.getNombreFacultad());
        facultadDAO.save(facultad);
        return "Se creo exitosamente la facultad";

    }

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
