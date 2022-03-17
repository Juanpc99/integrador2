package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.SemestreDAO;
import com.lenguageconquers.model.Semestre;
import com.lenguageconquers.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class SemestreServiceImpl implements SemestreService {

    @Autowired
    private SemestreDAO semestreDAO;

    @Override
    public Semestre registrar(Semestre semestre) {
        return semestreDAO.save(semestre);
    }

    @Override
    public Semestre modificar(Semestre semestre) {
        return semestreDAO.save(semestre);
    }

    @Override
    public void eliminar(int id) {
        //semestreDAO.deleteById(id);
    }

    @Override
    public Semestre listarId(int id) {
        return null;
        //return semestreDAO.findOne(id);
    }

    @Override
    public List<Semestre> listar() {
        return semestreDAO.findAll();
    }
}
