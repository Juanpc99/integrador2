package com.lenguageconquers.service;

import com.lenguageconquers.model.Comentario;
import com.lenguageconquers.model.dto.ComentarioDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioService {

    String crearComentarios(ComentarioDTO comentarioDTO);
    List<Comentario> listar();
    List<Comentario> listarPorIdRetoEstudiante(Long idRetoEstudiante) throws Exception;

}
