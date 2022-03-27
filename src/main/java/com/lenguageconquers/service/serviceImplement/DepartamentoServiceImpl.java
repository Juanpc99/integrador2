package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.DepartamentoDAO;
import com.lenguageconquers.dao.FacultadDAO;
import com.lenguageconquers.model.Departamento;
import com.lenguageconquers.model.dto.DepartamentoDTO;
import com.lenguageconquers.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoDAO departamentoDAO;

    @Autowired
    private FacultadDAO facultadDAO;

    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentoDAO.findAll();
    }

    @Override
    public String registrarDepartamento(DepartamentoDTO departamentoDTO) {
        try{
            Departamento departamento = new Departamento();
            departamento.setNombreDepartamento(departamentoDTO.getNombreDepartamento());
            departamento.setFacultad(facultadDAO.findById(departamentoDTO.getIdFacultad()).get());
            departamentoDAO.save(departamento);
            return "Se creo el departamento exitosamente";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
