package com.lenguageconquers.controller;

import com.lenguageconquers.model.Chat;
import com.lenguageconquers.model.dto.ChatDTO;
import com.lenguageconquers.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatControlles {
    @Autowired
    private ChatService chatService;

    @PostMapping("/mensajeEstudiante")
    public ResponseEntity<String> mensajeEstudiante(@RequestBody ChatDTO chatDTO){
        try {
            return new ResponseEntity<>(chatService.crearMensajeEstudiante(chatDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/mensajeProfesor")
    public ResponseEntity<String> mensajeProfesor(@RequestBody ChatDTO chatDTO){
        try {
            return new ResponseEntity<>(chatService.crearMensajeProfesor(chatDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<ChatDTO>> chat (@RequestParam Long idEstudiante, @RequestParam Long idProfesor){
        try {
            return new ResponseEntity<>(chatService.chat(idEstudiante, idProfesor), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
