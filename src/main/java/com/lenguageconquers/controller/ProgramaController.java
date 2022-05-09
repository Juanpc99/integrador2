package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.ProgramaMapper;
import com.lenguageconquers.model.Programa;
import com.lenguageconquers.model.dto.ProgramaDTO;
import com.lenguageconquers.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @Autowired
    private ProgramaMapper programaMapper;

    @GetMapping("/listar")
    public ResponseEntity<List<ProgramaDTO>> listarPorDepartamento(@RequestParam Long idDepartamento) {
        try {
           // List<ProgramaDTO> programaDTOS = programaService.listaProgramasPorDepartamento(idDepartamento);
            return new ResponseEntity<>(programaService.listaProgramasPorDepartamento(idDepartamento), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/crearPrograma")
    public ResponseEntity<String> guardarPrograma(@RequestBody ProgramaDTO programaDTO){
        try{
            return new ResponseEntity<>(programaService.crearPrograma(programaDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
    }
}
