package com.lenguageconquers.service;

import com.lenguageconquers.model.Mision;
import com.lenguageconquers.model.dto.MisionDTO;

import java.util.List;

public interface MisionService {

    String cargarMision(MisionDTO misionDTO) throws Exception;
    List<Mision> listarMisiones();
}
