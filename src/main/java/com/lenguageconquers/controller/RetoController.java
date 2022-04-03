package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.RetoMapper;
import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.dto.RetoDTO;
import com.lenguageconquers.service.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/retos")
public class RetoController {

    @Autowired
    private RetoService retoService;

    @Autowired
    private RetoMapper retoMapper;

    @GetMapping
    public ResponseEntity<List<RetoDTO>> listar(){
        List<Reto> retos = retoService.listar();
        List<RetoDTO> retoDTOList = new ArrayList<>();
        for (Reto reto: retos) {
            RetoDTO retoDTO = new RetoDTO();
            retoDTO.setIdReto(reto.getIdReto());
            retoDTO.setTituloReto(reto.getTituloReto());
            retoDTO.setDescripcionReto(reto.getDescripcionReto());
            retoDTO.setFechaLimite(reto.getFechaLimite());
            retoDTO.setFechaInicio(reto.getFechaInicio());
            retoDTO.setMaximoIntentos(reto.getMaximoIntentos());
            retoDTO.setIdCurso(reto.getCurso().getIdCurso());
            retoDTO.setIdEstado(reto.getEstado().getIdEstado());
            retoDTO.setIdMision(reto.getMision().getIdMision());
            retoDTOList.add(retoDTO);
        }
        return ResponseEntity.ok().body(retoDTOList);
    }

    @PutMapping("/actualizarEstado")
    public ResponseEntity<String> actualizarE(@RequestBody RetoDTO retoDTO){
        try {
            return new ResponseEntity<>(retoService.actualizarEstado(retoDTO), HttpStatus.OK);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje,HttpStatus.BAD_REQUEST);
        }
    }
}
