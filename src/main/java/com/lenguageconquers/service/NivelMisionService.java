package com.lenguageconquers.service;

import com.lenguageconquers.model.NivelMision;
import com.lenguageconquers.model.dto.NivelMisionDTO;

import java.util.List;

public interface NivelMisionService {

    String crearNivelMision(NivelMisionDTO nivelMisionDTO) throws Exception;
    List<NivelMision> listar();
}
