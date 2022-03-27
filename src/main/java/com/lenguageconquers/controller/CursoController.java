package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.CursoMapper;
import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.dto.CursoDTO;
import com.lenguageconquers.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoMapper cursoMapper;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listaCursos(){
        List<Curso> cursoList = cursoService.listaCursos();
        List<CursoDTO> cursoDTOS = cursoMapper.listCursoToCursoDTO(cursoList);
        return ResponseEntity.ok().body(cursoDTOS);
    }

    @PostMapping("/registrarCurso")
    public ResponseEntity<String> registrarCurso(@RequestBody CursoDTO cursoDTO){
        try{
            return new ResponseEntity<>(cursoService.registrarCurso(cursoDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>("Ocurrio un Error: " + mensaje, HttpStatus.BAD_REQUEST);
        }
    }
}
