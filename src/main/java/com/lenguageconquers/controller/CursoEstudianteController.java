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
            cursoEstudianteDTOS.add(cursoEstudianteDTO);
        }
        return ResponseEntity.ok().body(cursoEstudianteDTOS);
    }

    @GetMapping("/cursosEstudiante/{id}")
    public ResponseEntity<List<CursoEstudianteDTO>> listarCursosEstudiante(@PathVariable("id") Long id) throws Exception {
        List<CursoEstudiante> cursoEstudianteList = cursoEstudianteService.listaCursosMatriculadosPorEstudiate(id);
        List<CursoEstudianteDTO> cursoEstudianteDTOS = cursoEstudianteMapper.listCursoEstudianteToListCursoEstudianteDTO(cursoEstudianteList);
        return ResponseEntity.ok().body(cursoEstudianteDTOS);
    }


    @PostMapping("/matricularCurso")
    public ResponseEntity<String> matricular(@RequestBody CursoEstudianteDTO cursoEstudianteDTO){

        try {
            return new ResponseEntity<>( cursoEstudianteService.matricularCurso(cursoEstudianteDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

    /*
    @GetMapping("/buscarPorEstudianteMatriculado/{idCurso}/{idEstudiante}")
    public ResponseEntity<CursoEstudiante> listarCursoMatriculadosEstudiante(@RequestParam("idCurso")Long idCurso, @RequestParam("idEstudiante") Long idEstudiante){
        try{
            CursoEstudiante curso = cursoEstudianteService.buscarIdCursoYIdEstudiante(idCurso,idEstudiante);
            return ResponseEntity.ok().body(curso);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

     */

    //TODO: VERIFICAR METODO Y PONER EL MENSAJE EN EL SERVICE JUNTO CON LA VALIDACIONES
    @DeleteMapping("/EliminarCursoMatriculado/{idEstudiante}/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable("idEstudiante") Long idEstudiante,@PathVariable("id") Long id){
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
}
