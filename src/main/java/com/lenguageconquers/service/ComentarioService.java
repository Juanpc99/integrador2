package com.lenguageconquers.service;

import com.lenguageconquers.model.Comentario;
import com.lenguageconquers.model.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioService {

    String crearComentarios(ComentarioDTO comentarioDTO);
    List<Comentario> listar();
}
