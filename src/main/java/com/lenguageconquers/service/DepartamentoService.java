package com.lenguageconquers.service;


import com.lenguageconquers.model.Departamento;
import com.lenguageconquers.model.dto.DepartamentoDTO;

import java.util.List;

public interface DepartamentoService{
    List<Departamento> listarDepartamentos();
    String registrarDepartamento(DepartamentoDTO departamentoDTO);
}
