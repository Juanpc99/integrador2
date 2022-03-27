package com.lenguageconquers.service;


import com.lenguageconquers.model.Facultad;
import com.lenguageconquers.model.dto.FacultadDTO;

import java.util.List;

public interface FacultadService{

    List<Facultad> listarFacultades();
    String registrarFacultad(FacultadDTO facultadDTO);
}
