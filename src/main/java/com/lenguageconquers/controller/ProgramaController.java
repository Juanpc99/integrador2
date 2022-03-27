package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.ProgramaMapper;
import com.lenguageconquers.model.Programa;
import com.lenguageconquers.model.dto.ProgramaDTO;
import com.lenguageconquers.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @Autowired
    private ProgramaMapper programaMapper;

    @GetMapping("/listar/{idDepartamento}")
    public ResponseEntity<List<ProgramaDTO>> listarProgramasDepartamento(@PathVariable("idDepartamento") Long idDepartamento){
        List<Programa> programaList = programaService.listaProgramasPorDepartamento(idDepartamento);
        List<ProgramaDTO> programaDTOS = programaMapper.listProgramaToListProgramaDTO(programaList);
        for (Programa programa: programaList) {
            ProgramaDTO programaDTO = new ProgramaDTO();
            programaDTO.setIdPrograma(programa.getIdPrograma());
            programaDTO.setNombrePrograma(programa.getNombrePrograma());
            programaDTO.setIdDepartamento(programa.getDepartamento().getIdDepartamento());
            programaDTOS.add(programaDTO);
        }
        return ResponseEntity.ok().body(programaDTOS);
    }

    @PostMapping("/crearPrograma")
    public ResponseEntity<String> guardarPrograma(@RequestBody ProgramaDTO programaDTO){
        try{
            return new ResponseEntity<>(programaService.crearPrograma(programaDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
    }
}
