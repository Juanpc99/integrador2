package com.lenguageconquers.service;

import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.dto.RetoDTO;

import java.util.List;

public interface RetoService {

    String actualizarEstado(RetoDTO retoDTO) throws Exception;
    List<Reto> listar();
    Reto findByIdReto(Long idReto) throws Exception;

}
