package com.lenguageconquers.service;

import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.dto.RetoDTO;

import java.util.List;

public interface RetoService {

    String actualizarEstado(RetoDTO retoDTO) throws Exception;
    List<RetoDTO> listar() throws Exception;
    Reto findByIdReto(Long idReto) throws Exception;
    boolean elRetoEsGrupal(Long idReto) throws Exception;
    List<RetoDTO> findByIdCursoAndIdMision (Long idCurso, Long idMision) throws Exception;
    String agregarReto(RetoDTO retoDTO) throws Exception;
    String actualizarReto(RetoDTO retoDTO) throws Exception;
    String eliminarReto(Long idReto) throws Exception;

}
