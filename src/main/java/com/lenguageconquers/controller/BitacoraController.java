package com.lenguageconquers.controller;

import com.lenguageconquers.model.dto.BitacoraDTO;
import com.lenguageconquers.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bitacora")
public class BitacoraController {

    @Autowired
    BitacoraService bitacoraService;


    @GetMapping
    public ResponseEntity<List<BitacoraDTO>> listarPorEstudiante(@RequestParam Long idEstudiante){
        try {
            return new ResponseEntity<>(bitacoraService.listaRegistros(idEstudiante), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<String> crearRegistro(@RequestBody BitacoraDTO bitacoraDTO){
        try{
            return new ResponseEntity<>(bitacoraService.guardarRegistro(bitacoraDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    public ResponseEntity<String> actualizarRegistro(@RequestBody BitacoraDTO bitacoraDTO){
        try{
            return new ResponseEntity<>(bitacoraService.actualizarRegistro(bitacoraDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
