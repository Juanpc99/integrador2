package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.EstadoTipoMapper;
import com.lenguageconquers.model.EstadoTipo;
import com.lenguageconquers.model.dto.EstadoTipoDTO;
import com.lenguageconquers.service.EstadoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadoTipo")
public class EstadoTipoController {

    @Autowired
    private EstadoTipoService estadoTipoService;

    @Autowired
    private EstadoTipoMapper estadoTipoMapper;

    @GetMapping
    public ResponseEntity<List<EstadoTipoDTO>> listar(){
        List<EstadoTipo> estadoTipoList = estadoTipoService.listar();
        List<EstadoTipoDTO> estadoTipoDTOS = estadoTipoMapper.listEstadoTipoToListEstadoTipoDTO(estadoTipoList);
        return ResponseEntity.ok().body(estadoTipoDTOS);
    }

    @PostMapping("/registrarEstadoTipo")
    public ResponseEntity<String> registrar(@RequestBody EstadoTipoDTO estadoTipoDTO){
        try {
            return new ResponseEntity<>(estadoTipoService.crearEstadoTipo(estadoTipoDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje,HttpStatus.BAD_REQUEST);
        }
    }
}
