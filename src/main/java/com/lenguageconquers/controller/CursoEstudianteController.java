package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.CursoEstudianteMapper;

import com.lenguageconquers.model.CursoEstudiante;

import com.lenguageconquers.model.dto.CursoEstudianteDTO;
import com.lenguageconquers.service.CursoEstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursoEstudiante")
public class CursoEstudianteController {

    @Autowired
    private CursoEstudianteService cursoEstudianteService;

    @Autowired
    private CursoEstudianteMapper cursoEstudianteMapper;



    @GetMapping("/listar/{idEstudiante}/{idCurso}")
    public ResponseEntity<List<CursoEstudianteDTO>> listarCursosMatriculados(@PathVariable("idEstudiante") Long idEstudiante,
                                                                             @PathVariable("idCurso")Long idCurso){
        List<CursoEstudiante> cursoEstudianteList = cursoEstudianteService.listaCursosMatriculados(idEstudiante,idCurso);
        List<CursoEstudianteDTO> cursoEstudianteDTOS = new ArrayList<>();
        for (CursoEstudiante cursoEstudiante : cursoEstudianteList) {
            CursoEstudianteDTO cursoEstudianteDTO = new CursoEstudianteDTO();
            cursoEstudianteDTO.setIdCursoEstudiante(cursoEstudiante.getIdCursoEstudiante());
            cursoEstudianteDTO.setIdEstudiante(cursoEstudiante.getEstudiante().getIdEstudiante());
            cursoEstudianteDTO.setIdCurso(cursoEstudiante.getCurso().getIdCurso());
            cursoEstudianteDTO.setNivel(cursoEstudiante.getNivel());
            cursoEstudianteDTO.setPuntaje_estudiante(cursoEstudiante.getPuntaje_estuduante());
            cursoEstudianteDTOS.add(cursoEstudianteDTO);
        }
        return ResponseEntity.ok().body(cursoEstudianteDTOS);
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<List<CursoEstudianteDTO>> listarCursosEstudiante(@PathVariable("id") Long id) throws Exception {
        try{
            List<CursoEstudianteDTO> cursoEstudianteList = cursoEstudianteService.listarPorIdEstudiante(id);
            return ResponseEntity.ok().body(cursoEstudianteList);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/matricularCurso")
    public ResponseEntity<String> matricular(@RequestParam Long idCurso, @RequestParam Long idEstudiante, @RequestParam String password){

        try {
            return new ResponseEntity<>( cursoEstudianteService.matricularCurso2(idEstudiante, idCurso, password), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }


    //TODO: VERIFICAR METODO Y PONER EL MENSAJE EN EL SERVICE JUNTO CON LA VALIDACIONES
    @DeleteMapping("/EliminarCursoMatriculado")
    public ResponseEntity<?> eliminarCurso(@RequestParam Long idEstudiante,@RequestParam Long id){
        try {
            cursoEstudianteService.eliminarMatricula(idEstudiante, id);
            return ResponseEntity.ok("Se ha desmatriculado del curso satisfactoriamente");
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/ListarPorId")
    public ResponseEntity<List<CursoEstudianteDTO>> listarPorIdEstudiante(@RequestParam Long idEstudiante){
        try {
            List<CursoEstudianteDTO> cursoEstudianteDTOList = cursoEstudianteService.listarPorIdEstudiante(idEstudiante);

            return new ResponseEntity(cursoEstudianteDTOList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/subirNivel")
    public ResponseEntity<String> subirNivel(@RequestParam Long nivel, @RequestParam Long idEstudiante, @RequestParam Long idCurso){
        try {
            return new ResponseEntity<>(cursoEstudianteService.subirDeNivel(nivel, idEstudiante, idCurso), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/Ranking")
    public ResponseEntity<List<CursoEstudianteDTO>> listarRankings(@RequestParam Long idCurso){
        try{
           List<CursoEstudianteDTO> cursoEstudianteDTOS = cursoEstudianteService.listarRanking(idCurso);
            return new ResponseEntity<>(cursoEstudianteDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/notaFinal")
    public ResponseEntity<Double> notaFinal(@RequestParam Long idEstudiante, @RequestParam Long idCurso){
        try{
            Double notaFinal = cursoEstudianteService.notaFinal(idEstudiante, idCurso);
            return new ResponseEntity<>(notaFinal, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
