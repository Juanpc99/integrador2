package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.GeneroMapper;
import com.lenguageconquers.model.Genero;
import com.lenguageconquers.model.dto.GeneroDTO;
import com.lenguageconquers.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @Autowired
    private GeneroMapper generoMapper;

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> listar(){
        List<Genero> generoList = generoService.listaGeneros();
        List<GeneroDTO> generoDTOS = generoMapper.listGeneroToListGeneroDTO(generoList);
        return ResponseEntity.ok().body(generoDTOS);

    }

    @PostMapping("/crearGenero")
    public ResponseEntity<String> crearGenero(@RequestBody GeneroDTO generoDTO){
        try{
            return new ResponseEntity<>(generoService.registrarGenero(generoDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
    }
}
