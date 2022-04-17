package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.ChatDAO;
import com.lenguageconquers.dao.EstudianteDAO;
import com.lenguageconquers.dao.ProfesorDAO;
import com.lenguageconquers.model.Chat;
import com.lenguageconquers.model.dto.ChatDTO;
import com.lenguageconquers.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Scope("singleton")
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatDAO chatDAO;
    @Autowired
    private EstudianteDAO estudianteDAO;
    @Autowired
    private ProfesorDAO profesorDAO;

    @Override
    public String crearMensajeEstudiante(ChatDTO chatDTO) throws Exception {
        if(chatDTO.getMensaje().length() >= 200 || chatDTO.getMensaje().length() <= 0) {
            throw new Exception("El mensaje debe tener por lo menos 1 caracter y no debe tener mas de 200");
        }
        if(estudianteDAO.existsById(chatDTO.getIdEstudiante()) == false){
            throw new Exception("El estudiante con el id " + chatDTO.getIdEstudiante() + " no existe");
        }
        if(profesorDAO.existsById(chatDTO.getIdProfesor()) == false){
            throw new Exception("El profesor con el id " + chatDTO.getIdProfesor() + " no existe");
        }
        chatDTO.setRemitente("E");
        Chat chat = mapeo(chatDTO);
        chatDAO.save(chat);
        return chatDTO.getMensaje();
    }

    @Override
    public String crearMensajeProfesor(ChatDTO chatDTO) throws Exception {
        if(chatDTO.getMensaje().length() >= 200 || chatDTO.getMensaje().length() <= 0) {
            throw new Exception("El mensaje debe tener por lo menos 1 caracter y no debe tener mas de 200");
        }
        if(estudianteDAO.existsById(chatDTO.getIdEstudiante()) == false){
            throw new Exception("El estudiante con el id " + chatDTO.getIdEstudiante() + " no existe");
        }
        if(profesorDAO.existsById(chatDTO.getIdProfesor()) == false){
            throw new Exception("El profesor con el id " + chatDTO.getIdProfesor() + " no existe");
        }
        chatDTO.setRemitente("P");
        Chat chat = mapeo(chatDTO);
        chatDAO.save(chat);
        return chatDTO.getMensaje();
    }

    @Override
    public List<ChatDTO> chat(Long idEstudiante, Long idProfesor) throws Exception {
        if(estudianteDAO.existsById(idEstudiante) == false){
            throw new Exception("El estudiante con el id " + idEstudiante + " no existe");
        }
        if(profesorDAO.existsById(idProfesor) == false){
            throw new Exception("El profesor con el id " + idProfesor + " no existe");
        }
        List<Chat> chats = chatDAO.findByIdEstudianteAndIdProfesor(idEstudiante, idProfesor);
        List<ChatDTO> chatDTOS = mapeooListDTO(chats);
        return chatDTOS;
    }

    private Chat mapeo (ChatDTO chatDTO){
        Chat chat = new Chat();

        chat.setEstudiante(estudianteDAO.findById(chatDTO.getIdEstudiante()).get());
        chat.setProfesor(profesorDAO.findById(chatDTO.getIdProfesor()).get());
        chat.setFecha(new Date());
        chat.setRemitente(chatDTO.getRemitente());
        chat.setMensaje(chatDTO.getMensaje());
        return chat;
    }
    private ChatDTO mapeoChatDTO (Chat chat){
        ChatDTO chatDTO = new ChatDTO();

        chatDTO.setIdChat(chat.getIdChat());
        chatDTO.setFecha(chat.getFecha());
        chatDTO.setMensaje(chat.getMensaje());
        chatDTO.setRemitente(chat.getRemitente());
        chatDTO.setIdEstudiante(chat.getEstudiante().getIdEstudiante());
        chatDTO.setIdProfesor(chat.getProfesor().getId());

        return chatDTO;
    }
    private List<ChatDTO> mapeooListDTO(List<Chat> chats){
        List<ChatDTO> chatDTOS = new ArrayList<>();
        for (Chat chat: chats){
            ChatDTO chatDTO = mapeoChatDTO(chat);
            chatDTOS.add(chatDTO);
        }
        return chatDTOS;
    }
}
