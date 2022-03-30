package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.RecompensaMapper;
import com.lenguageconquers.model.Recompensa;
import com.lenguageconquers.model.dto.RecompensaDTO;
import com.lenguageconquers.service.RecompensaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recompensa")
public class RecompensaController {

    @Autowired
    private RecompensaService recompensaService;

    @Autowired
    private RecompensaMapper recompesaMapper;

    @GetMapping
    public ResponseEntity<List<RecompensaDTO>> listar(){
        List<Recompensa> recompensaList = recompensaService.listar();
        List<RecompensaDTO> recompensaDTOS = recompesaMapper.listRecompensaToRecompensaDTO(recompensaList);
        return ResponseEntity.ok().body(recompensaDTOS);
    }

    @PostMapping("/crearRecompensa")
    public ResponseEntity<String> crear(@RequestBody RecompensaDTO recompensaDTO){
        try {
            return new ResponseEntity<>(recompensaService.crearRecompensa(recompensaDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

}
