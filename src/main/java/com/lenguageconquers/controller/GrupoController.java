package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.GrupoMapper;
import com.lenguageconquers.model.Grupos;
import com.lenguageconquers.model.dto.GruposDTO;
import com.lenguageconquers.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private GrupoMapper grupoMapper;

    @GetMapping
    public ResponseEntity<List<GruposDTO>> listar(){
        List<Grupos> grupos = grupoService.listar();
        List<GruposDTO> gruposDTOS = new ArrayList<>();
        for (Grupos grupos1: grupos){
            GruposDTO gruposDTO = new GruposDTO();
            gruposDTO.setIdGrupo(grupos1.getIdGrupo());
            gruposDTO.setNombreGrupo(grupos1.getNombreGrupo());
            gruposDTOS.add(gruposDTO);
        }
        return ResponseEntity.ok().body(gruposDTOS);
    }

    @PostMapping("/crearGrupo")
    public ResponseEntity<String> crear(@RequestBody GruposDTO gruposDTO){
        try{
            return new ResponseEntity<>(grupoService.crearGrupo(gruposDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/actualizarGrupo")
    public ResponseEntity<String> actualizar(@RequestBody GruposDTO gruposDTO){
        try{
            return new ResponseEntity<>(grupoService.actualizarGrupo(gruposDTO), HttpStatus.OK);
        } catch (Exception e) {
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }
}
