package com.lenguageconquers.service;


import com.lenguageconquers.model.RolReto;
import com.lenguageconquers.model.dto.RolDTO;
import com.lenguageconquers.model.dto.RolRetoDTO;

public interface RolService {

    String crearRol(String nombreRol, Long idReto) throws Exception;

}
