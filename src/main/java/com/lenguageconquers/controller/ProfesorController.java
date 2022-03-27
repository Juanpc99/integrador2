package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.ProfesorMapper;
import com.lenguageconquers.model.Profesor;
import com.lenguageconquers.model.dto.ProfesorDTO;
import com.lenguageconquers.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private ProfesorMapper profesorMapper;

    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> listar(){
        List<Profesor> profesorList = profesorService.listarProfesores();
        List<ProfesorDTO> profesorDTOS = profesorMapper.listProfesorToListProfesorDTO(profesorList);
        return ResponseEntity.ok().body(profesorDTOS);
    }

    @PostMapping("/registrarProfesor")
    public ResponseEntity<String> registrar(@RequestBody ProfesorDTO profesorDTO){
        try {
            return new ResponseEntity<>(profesorService.registarProfesor(profesorDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje,HttpStatus.BAD_REQUEST);
        }
    }
}
