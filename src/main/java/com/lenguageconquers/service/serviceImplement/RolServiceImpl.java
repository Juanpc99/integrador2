package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.RolDAO;
import com.lenguageconquers.model.Rol;
import com.lenguageconquers.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDAO rolDAO;

    @Override
    public Rol registrar(Rol rol) {
        return rolDAO.save(rol);
    }

    @Override
    public Rol modificar(Rol rol) {
        return rolDAO.save(rol);
    }

    @Override
    public void eliminar(int id) {
        //rolDAO.delete(id);
    }

    @Override
    public Rol listarId(int id) {
        return null;
        //return rolDAO.findOne(id);
    }

    @Override
    public List<Rol> listar() {
        return rolDAO.findAll();
    }
}
