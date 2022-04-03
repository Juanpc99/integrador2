package com.lenguageconquers.service;

import com.lenguageconquers.model.TipoMision;
import com.lenguageconquers.model.dto.TipoMisionDTO;

import java.util.List;

public interface TipoMisionService {

    String crearTipoMision(TipoMisionDTO tipoMisionDTO) throws Exception;
    List<TipoMision> listar();
}
