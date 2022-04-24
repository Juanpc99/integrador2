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
        try {
            return new ResponseEntity<>(retoService.listar(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/informacionRetos")
    public ResponseEntity<List<RetoDTO>> listarInformacionRetosPorMisionYCurso(@RequestParam Long idCurso, @RequestParam Long idMision){
        try {
            return new ResponseEntity<>(retoService.findByIdCursoAndIdMision(idCurso, idMision), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/esGrupo")
    public ResponseEntity<Boolean> esGrupo(@RequestParam Long idReto){
        try {
            return new ResponseEntity<>(retoService.elRetoEsGrupal(idReto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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
    @PostMapping
    public ResponseEntity<String> crearReto(@RequestBody RetoDTO retoDTO){
        try {
            return new ResponseEntity<>(retoService.agregarReto(retoDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    public ResponseEntity<String> editarReto(@RequestBody RetoDTO retoDTO){
        try {
            return new ResponseEntity<>(retoService.actualizarReto(retoDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping
    public ResponseEntity<String> eliminarReto(@RequestParam Long idReto){
        try {
            return new ResponseEntity<>(retoService.eliminarReto(idReto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
