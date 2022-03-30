package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.TipoMisionMapper;
import com.lenguageconquers.model.TipoMision;
import com.lenguageconquers.model.dto.TipoMisionDTO;
import com.lenguageconquers.service.TipoMisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoMision")
public class TipoMisionController {

    @Autowired
    private TipoMisionService tipoMisionService;

    @Autowired
    private TipoMisionMapper tipoMisionMapper;

    @GetMapping
    public ResponseEntity<List<TipoMisionDTO>> listar(){
        List<TipoMision> tipoMisionList = tipoMisionService.listar();
        List<TipoMisionDTO> tipoMisionDTOS = tipoMisionMapper.listTipoMisionToListTipoMisionDTO(tipoMisionList);
        return ResponseEntity.ok().body(tipoMisionDTOS);
    }

    @PostMapping("/crearTipoMision")
    public ResponseEntity<String> crear(@RequestBody TipoMisionDTO tipoMisionDTO){
        try {
            return new ResponseEntity<>(tipoMisionService.crearTipoMision(tipoMisionDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

}
