package com.lenguageconquers.service;

import com.lenguageconquers.model.Chat;
import com.lenguageconquers.model.dto.ChatDTO;

import java.util.List;

public interface ChatService {

    String crearMensajeEstudiante (ChatDTO chatDTO) throws Exception;
    String crearMensajeProfesor (ChatDTO chatDTO) throws Exception;
    List<ChatDTO> chat (Long idEstudiante, Long idProfesor) throws Exception;
}
