package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.FacultadMapper;
import com.lenguageconquers.model.Facultad;
import com.lenguageconquers.model.dto.FacultadDTO;
import com.lenguageconquers.service.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultad")
public class FacultadController {

    @Autowired
    private FacultadService facultadService;

    @Autowired
    private FacultadMapper facultadMapper;

    @GetMapping
    public ResponseEntity<List<FacultadDTO>> listar(){
        List<Facultad> facultadList = facultadService.listarFacultades();
        List<FacultadDTO> facultadDTOS = facultadMapper.listFacultadToListFacultadDTO(facultadList);
        return ResponseEntity.ok().body(facultadDTOS);
    }

    @PostMapping("/registrarFacultad")
    public ResponseEntity<String> guardar(@RequestBody FacultadDTO facultadDTO){
        try{
            return new ResponseEntity<>(facultadService.registrarFacultad(facultadDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
    }
}
