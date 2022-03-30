package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.NivelMisionMapper;
import com.lenguageconquers.model.NivelMision;
import com.lenguageconquers.model.dto.NivelMisionDTO;
import com.lenguageconquers.service.NivelMisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nivelMision")
public class NivelMisionController {

    @Autowired
    private NivelMisionService nivelMisionService;

    @Autowired
    private NivelMisionMapper nivelMisionMapper;

    @GetMapping
    public ResponseEntity<List<NivelMisionDTO>> listarNivel(){
        List<NivelMision>nivelMisions = nivelMisionService.listar();
        List<NivelMisionDTO> nivelMisionDTOS = nivelMisionMapper.listNivelMisionToListNivelMisionDTO(nivelMisions);
        return ResponseEntity.ok().body(nivelMisionDTOS);
    }

    @PostMapping("/crearNivelM")
    public ResponseEntity<String> crear(@RequestBody NivelMisionDTO nivelMisionDTO){
        try {
            return new ResponseEntity<>(nivelMisionService.crearNivelMision(nivelMisionDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje,HttpStatus.BAD_REQUEST);
        }
    }

}
