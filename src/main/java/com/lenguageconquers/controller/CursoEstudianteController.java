package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.CursoEstudianteMapper;
import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;
import com.lenguageconquers.service.CursoEstudianteService;
import com.lenguageconquers.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursoEstudiante")
public class CursoEstudianteController {

    @Autowired
    private CursoEstudianteService cursoEstudianteService;

    @Autowired
    private CursoEstudianteMapper cursoEstudianteMapper;

    @GetMapping
    public ResponseEntity<List<CursoEstudianteDTO>> listarCursosMatriculados(){
        List<CursoEstudiante> cursoEstudianteList = cursoEstudianteService.listaCursosMatriculados();
        List<CursoEstudianteDTO> cursoEstudianteDTOS = cursoEstudianteMapper.listCursoEstudianteToListCursoEstudianteDTO(cursoEstudianteList);
        return ResponseEntity.ok().body(cursoEstudianteDTOS);
    }

    @PostMapping("/matricularCurso")
    public ResponseEntity<String> matricular(@RequestBody CursoEstudianteDTO cursoEstudianteDTO){

        try {
            return new ResponseEntity<>(cursoEstudianteService.matricularCurso(cursoEstudianteDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity("error, hola", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/EliminarCursoMatriculado/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable("id") Long id){
        try {
            cursoEstudianteService.eliminarMatricula(id);
            return ResponseEntity.ok("Se ha desmatriculado del curso satisfactoriamente");
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }
}
