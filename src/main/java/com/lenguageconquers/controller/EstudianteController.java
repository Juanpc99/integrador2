package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.EstudianteMapper;
import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.dto.EstudianteDTO;
import com.lenguageconquers.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.tree.ExpandVetoException;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private EstudianteMapper estudianteMapper;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> listar(){
        List<Estudiante> estudianteList = estudianteService.listaEstudiantes();
        List<EstudianteDTO> estudianteDTOS = estudianteMapper.listEstudianteToListEstudianteDTO(estudianteList);
        return ResponseEntity.ok().body(estudianteDTOS);
    }

    @PostMapping("/crearEstudiante")
    public ResponseEntity<String> crear(@RequestBody EstudianteDTO estudianteDTO){
        try {
            return new ResponseEntity<>(estudianteService.crearEstudiante(estudianteDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

}
