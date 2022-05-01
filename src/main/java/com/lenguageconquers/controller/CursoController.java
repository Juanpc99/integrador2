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
        try {
            List<CursoDTO> cursoDTOS = cursoService.listaCursos();
            return ResponseEntity.ok().body(cursoDTOS);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

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

    @GetMapping("/CursosDisponiblesEstudiantes")
    public ResponseEntity<CursoDTO> cursosDisponiblesEstudiantes(@RequestParam Long idEstudiante){
        try {
            List<CursoDTO> cursoDTOList = cursoService.encontrarPorIdEstudianteCursosConProgramaIgual(idEstudiante);
            return new ResponseEntity(cursoDTOList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/CursosPorFacultad")
//    public ResponseEntity<List<CursoDTO>> cursosPorIdFacultad(@RequestParam Long idFacultad){
//        try{
//            List<CursoDTO> cursoDTOList = cursoService.encontrarPorIdFacultad(idFacultad);
//            return new ResponseEntity(cursoDTOList, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping("/CursosPorFacultadYEstado")
//    public ResponseEntity<List<CursoDTO>> cursosPorIdFacultadYEstado(@RequestParam Long idFacultad, @RequestParam Long idEstado){
//        try {
//            List<CursoDTO> cursoDTOList = cursoService.encontrarPorIdFacultadeIdEstado(idFacultad, idEstado);
//            return new ResponseEntity(cursoDTOList, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping("/progreso")
    public ResponseEntity<Integer> preogresoCurso(@RequestParam Long idEstudiante, @RequestParam Long idCurso){
        try {
            return new ResponseEntity<>(cursoService.progresoCurso(idEstudiante, idCurso), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
