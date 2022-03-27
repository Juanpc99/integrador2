package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.CursoMapper;
import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.dto.CursoDTO;
import com.lenguageconquers.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoMapper cursoMapper;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listar(){
        List<Curso> cursoList = cursoService.listaCursos();
        List<CursoDTO> cursoDTOS = cursoMapper.listCursoToListCursoDTO(cursoList);
        for (CursoDTO curso: cursoDTOS) {
            System.out.println(curso.getIdProfesor());
        }
        return ResponseEntity.ok().body(cursoDTOS);
    }

    @PostMapping("/registrarCurso")
    public ResponseEntity<String> registrar(@RequestBody CursoDTO cursoDTO){
        try{
            return new ResponseEntity<>(cursoService.registrarCurso(cursoDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>("Ocurrio un Error: " + mensaje, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/listarPorEstudiante/{idCurso}/{idEstudiante}")
    public ResponseEntity<CursoDTO> listarCursosEstu(@PathVariable("idCurso") Long idCurso, @PathVariable("idEstudiante") Long idEstudiante)  {
        try{
            CursoDTO cursoDTO = cursoService.findById(idCurso, idEstudiante);
            return new ResponseEntity<>(cursoDTO, HttpStatus.OK);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }




}
