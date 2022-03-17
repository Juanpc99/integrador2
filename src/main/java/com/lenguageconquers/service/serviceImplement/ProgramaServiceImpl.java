package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.ProgramaDAO;
import com.lenguageconquers.model.Programa;
import com.lenguageconquers.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    private ProgramaDAO programaDAO;

    @Override
    public Programa registrar(Programa programa) {
        return programaDAO.save(programa);
    }

    @Override
    public Programa modificar(Programa programa) {
        return programaDAO.save(programa);
    }

    @Override
    public void eliminar(int id) {
        //programaDAO.delete(id);
    }

    @Override
    public Programa listarId(int id) {
        return null;
        //return programaDAO.findOne(id);
    }

    @Override
    public List<Programa> listar() {
        return programaDAO.findAll();
    }
}
