package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.RetoEstudianteMapper;
import com.lenguageconquers.model.RetoEstudiante;
import com.lenguageconquers.model.dto.RetoEstudianteDTO;
import com.lenguageconquers.service.RetoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/retoEstudiante")
public class RetoEstudianteController {

    @Autowired
    private RetoEstudianteService retoEstudianteService;

    @Autowired
    private RetoEstudianteMapper retoEstudianteMapper;

    @GetMapping
    public ResponseEntity<List<RetoEstudianteDTO>> listar(){
        List<RetoEstudiante> retoEstudiantes = retoEstudianteService.listar();
        List<RetoEstudianteDTO> retoEstudianteDTOS = new ArrayList<>();
        for (RetoEstudiante retoEstudiante: retoEstudiantes) {
            RetoEstudianteDTO retoEstudianteDTO = new RetoEstudianteDTO();
            retoEstudianteDTO.setIdRetoEstudiante(retoEstudiante.getIdRetoEstudiante());
            retoEstudianteDTO.setIdReto(retoEstudiante.getReto().getIdReto());
            retoEstudianteDTO.setIdEstudiante(retoEstudiante.getEstudiante().getIdEstudiante());
            retoEstudianteDTO.setEstadoTarea(retoEstudianteDTO.getEstadoTarea());
            retoEstudianteDTO.setFechaSubida(retoEstudiante.getFechaSubida());
            retoEstudianteDTO.setUrlArchivo(retoEstudiante.getUrlArchivo());
            retoEstudianteDTOS.add(retoEstudianteDTO);
        }
        return ResponseEntity.ok().body(retoEstudianteDTOS);
    }

    @PostMapping("/crearRetoEstudiante")
    public ResponseEntity<String> crear(@RequestBody RetoEstudianteDTO retoEstudianteDTO){
        try{
            return new ResponseEntity<>(retoEstudianteService.crearRetoEstudiante(retoEstudianteDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

}
