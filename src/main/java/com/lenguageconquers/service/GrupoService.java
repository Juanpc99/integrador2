package com.lenguageconquers.service;

import com.lenguageconquers.model.Grupos;
import com.lenguageconquers.model.dto.GruposDTO;

import java.util.List;

public interface GrupoService {

    String crearGrupo(GruposDTO gruposDTO) throws Exception;
    String actualizarGrupo(GruposDTO gruposDTO) throws Exception;
    List<Grupos> listar();
}
