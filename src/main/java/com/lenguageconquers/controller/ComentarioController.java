package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.ComentarioMapper;
import com.lenguageconquers.model.Comentario;
import com.lenguageconquers.model.dto.ComentarioDTO;
import com.lenguageconquers.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private ComentarioMapper comentarioMapper;

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> listar(){
        try {
            List<ComentarioDTO> comentarioDTOS = comentarioService.listar();
            return new ResponseEntity<>(comentarioDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/comentariosPorIdRetoE/{idEstudiante}/{idReto}")
    public ResponseEntity<List<ComentarioDTO>> listarPorIdReto(@PathVariable("idEstudiante") Long idEstudiante, @PathVariable("idReto")Long idReto){
        try {
            List<ComentarioDTO> comentarioDTOS = comentarioService.listarPorIdRetoEstudiante(idEstudiante, idReto);
            return new ResponseEntity(comentarioDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/crearComentario")
    public ResponseEntity<String> crear(@RequestBody ComentarioDTO comentarioDTO){
        try {
            return new ResponseEntity<>(comentarioService.crearComentarios(comentarioDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje,HttpStatus.BAD_REQUEST);
        }

    }
}
