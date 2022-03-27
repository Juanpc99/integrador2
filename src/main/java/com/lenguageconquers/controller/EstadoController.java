package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.EstadoMapper;
import com.lenguageconquers.model.Estado;
import com.lenguageconquers.model.dto.EstadoDTO;
import com.lenguageconquers.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private EstadoMapper estadoMapper;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> listar(){
        List<Estado> estadoList = estadoService.listaEstados();
        List<EstadoDTO> estadoDTOS = new ArrayList<>();
        for (Estado estado: estadoList) {
            EstadoDTO estadoDTO = new EstadoDTO();
            estadoDTO.setIdEstado(estado.getIdEstado());
            estadoDTO.setNombreEstado(estado.getNombreEstado());
            estadoDTO.setIdEstadoTipo(estado.getEstadoTipo().getIdEstadoTipo());
            estadoDTOS.add(estadoDTO);
        }
        return ResponseEntity.ok().body(estadoDTOS);
    }

    @GetMapping("/listarPorTipo/{id}")
    public ResponseEntity<List<EstadoDTO>> listarPorIdTipo(@PathVariable("id")Long id){
        List<Estado> estadoList = estadoService.listaEstadosTipo(id);
        List<EstadoDTO> estadoDTOS = new ArrayList<>();
        for (Estado estado: estadoList) {
            EstadoDTO estadoDTO = new EstadoDTO();
            estadoDTO.setIdEstado(estado.getIdEstado());
            estadoDTO.setNombreEstado(estado.getNombreEstado());
            estadoDTO.setIdEstadoTipo(estado.getEstadoTipo().getIdEstadoTipo());
            estadoDTOS.add(estadoDTO);
        }
        return ResponseEntity.ok().body(estadoDTOS);
    }

    @PostMapping("/crearEstado")
    public ResponseEntity<String> crear(@RequestBody EstadoDTO estadoDTO){
        try {
            return new ResponseEntity<>(estadoService.crearEstado(estadoDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
    }
}
