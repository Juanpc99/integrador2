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
        List<Archivo> archivoList = archivoService.listar();
        List<ArchivosDTO> archivosDTOS = new ArrayList<>();
        for (Archivo archivo: archivoList) {
            ArchivosDTO archivosDTO = new ArchivosDTO();
            archivosDTO.setIdArchivo(archivo.getIdArchivo());
            archivosDTO.setArchivo(archivo.getArchivo());
            archivosDTO.setFechaCreacion(archivo.getFechaCreacion());
            archivosDTO.setTitulo(archivo.getTitulo());
            archivosDTO.setIdCurso(archivo.getCurso().getIdCurso());
            archivosDTO.setIdProfesor(archivo.getProfesor().getId());
            archivosDTOS.add(archivosDTO);
        }
        return ResponseEntity.ok().body(archivosDTOS);
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
