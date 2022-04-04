package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.ArchivoMapper;
import com.lenguageconquers.model.Archivo;
import com.lenguageconquers.model.dto.ArchivosDTO;
import com.lenguageconquers.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;

    @Autowired
    private ArchivoMapper archivoMapper;

    @GetMapping
    public ResponseEntity<List<ArchivosDTO>> listarArchivos(){
        try {
            List<ArchivosDTO> archivosDTOS = archivoService.listar();
            return new ResponseEntity<>(archivosDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/subirArchivo")
    public ResponseEntity<String> subir(@RequestBody ArchivosDTO archivosDTO){
        try {
            return new ResponseEntity<>(archivoService.subirArchivo(archivosDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje,HttpStatus.BAD_REQUEST);
        }
    }
}
