package com.lenguageconquers.service;

import com.lenguageconquers.model.Estado;
import com.lenguageconquers.model.dto.EstadoDTO;

import java.util.List;

public interface EstadoService {

    String crearEstado(EstadoDTO estadoDTO);
    List<Estado> listaEstados();
    List<Estado> listaPoridEstadoTipo(Long idEstadoTipo) throws Exception;
}
