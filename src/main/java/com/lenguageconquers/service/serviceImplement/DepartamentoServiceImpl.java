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
    public String registrarDepartamento(DepartamentoDTO departamentoDTO) throws Exception {
        Departamento departamento = new Departamento();
        if(departamentoDTO.getIdFacultad() == null){
            throw new Exception("Debe ingresar el id de facultad");
        }
        if(departamentoDTO.getIdFacultad()<0){
            throw new Exception("Debe ingresar un id mayor a 0");
        }
        if(facultadDAO.findById(departamentoDTO.getIdFacultad()).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id de facultad, valido");
        }
        if(departamentoDTO.getNombreDepartamento() == null || departamentoDTO.getNombreDepartamento().trim().equals("")){
            throw new Exception("Debe ingresar un nombre de departamento");
        }
        if(departamentoDTO.getNombreDepartamento().length()>50){
            throw new Exception("El nombre del departamento esta muy largo");
        }
        departamento.setNombreDepartamento(departamentoDTO.getNombreDepartamento());
        departamento.setFacultad(facultadDAO.findById(departamentoDTO.getIdFacultad()).get());
        departamentoDAO.save(departamento);
        return "Se creo el departamento exitosamente";

    }


}
