package com.lenguageconquers.service;

import com.lenguageconquers.model.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioService {

    String crearComentarios(ComentarioDTO comentarioDTO) throws Exception;
    List<ComentarioDTO> listar() throws Exception;
    List<ComentarioDTO> listarPorIdRetoEstudiante(Long idEstudiante, Long idReto) throws Exception;

}
