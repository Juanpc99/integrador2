package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.RolEstudianteDAO;
import com.lenguageconquers.model.RolEstudiante;
import com.lenguageconquers.service.RolEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class RolEstudianteServiceImpl implements RolEstudianteService {

    @Autowired
    private RolEstudianteDAO rolEstudianteDAO;

    @Override
    public RolEstudiante registrar(RolEstudiante rolEstudiante) {
        return rolEstudianteDAO.save(rolEstudiante);
    }

    @Override
    public RolEstudiante modificar(RolEstudiante rolEstudiante) {
        return rolEstudianteDAO.save(rolEstudiante);
    }

    @Override
    public void eliminar(int id) {
        //rolEstudianteDAO.delete(id);
    }

    @Override
    public RolEstudiante listarId(int id) {
        return null;
        //return rolEstudianteDAO.findOne(id);
    }

    @Override
    public List<RolEstudiante> listar() {
        return rolEstudianteDAO.findAll();
    }
}
