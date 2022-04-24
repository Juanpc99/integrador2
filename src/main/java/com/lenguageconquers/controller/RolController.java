package com.lenguageconquers.controller;

import com.lenguageconquers.model.dto.RolDTO;
import com.lenguageconquers.model.dto.RolRetoDTO;
import com.lenguageconquers.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearRol(@RequestParam String nombreRol, Long idReto){
        try{
            return new ResponseEntity<>(rolService.crearRol(nombreRol, idReto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
