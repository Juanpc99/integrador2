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
        List<Comentario> comentarios = comentarioService.listar();
        List<ComentarioDTO> comentarioDTOS = new ArrayList<>();
        for (Comentario comentario: comentarios) {
            ComentarioDTO comentarioDTO = new ComentarioDTO();
            comentarioDTO.setIdComentario(comentario.getIdComentario());
            comentarioDTO.setComentarios(comentario.getComentarios());
            comentarioDTO.setIdRetoEstudiante(comentario.getRetoEstudiante().getIdRetoEstudiante());
            comentarioDTOS.add(comentarioDTO);
        }
        return ResponseEntity.ok().body(comentarioDTOS);
    }

    @GetMapping("/comentariosPorIdRetoE/{idEstudiante}/{idReto}")
    public ResponseEntity<List<ComentarioDTO>> listarPorIdReto(@PathVariable("idEstudiante") Long idEstudiante, @PathVariable("idReto")Long idReto) throws Exception {
        List<Comentario> comentarios = comentarioService.listarPorIdRetoEstudiante(idEstudiante, idReto);
        List<ComentarioDTO> comentarioDTOS = new ArrayList<>();
        for (Comentario comentario: comentarios) {
            ComentarioDTO comentarioDTO = new ComentarioDTO();
            comentarioDTO.setIdComentario(comentario.getIdComentario());
            comentarioDTO.setIdReto(comentario.getRetoEstudiante().getReto().getIdReto());
            comentarioDTO.setComentarios(comentario.getComentarios());
            comentarioDTO.setIdRetoEstudiante(comentario.getRetoEstudiante().getIdRetoEstudiante());
            comentarioDTO.setIdEstudiante(comentario.getRetoEstudiante().getEstudiante().getIdEstudiante());
            comentarioDTO.setIdProfesor(comentario.getRetoEstudiante().getReto().getCurso().getProfesor().getId());
            comentarioDTOS.add(comentarioDTO);
        }
        return ResponseEntity.ok().body(comentarioDTOS);
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
