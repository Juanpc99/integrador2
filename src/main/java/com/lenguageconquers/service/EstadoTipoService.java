package com.lenguageconquers.service;

import com.lenguageconquers.model.EstadoTipo;
import com.lenguageconquers.model.dto.EstadoTipoDTO;

import java.util.List;

public interface EstadoTipoService {

    String crearEstadoTipo(EstadoTipoDTO estadoTipoDTO) throws Exception;
    List<EstadoTipo> listar();
    EstadoTipo findByNombreEstadoTipo(String nombreEstadoTipo) throws Exception;
}
