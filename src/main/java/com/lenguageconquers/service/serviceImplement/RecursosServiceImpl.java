package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.RecursosDAO;
import com.lenguageconquers.model.Recursos;
import com.lenguageconquers.service.RecursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class RecursosServiceImpl implements RecursosService {

    @Autowired
    private RecursosDAO recursosDAO;

    @Override
    public Recursos registrar(Recursos recursos) {
        return recursosDAO.save(recursos);
    }

    @Override
    public Recursos modificar(Recursos recursos) {
        return recursosDAO.save(recursos);
    }

    @Override
    public void eliminar(int id) {
        //recursosDAO.delete(id);
    }

    @Override
    public Recursos listarId(int id) {
        return null;
        //return recursosDAO.findOne(id);
    }

    @Override
    public List<Recursos> listar() {
        return recursosDAO.findAll();
    }
}
