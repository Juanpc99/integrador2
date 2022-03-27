package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.DepartamentoMapper;
import com.lenguageconquers.model.Departamento;
import com.lenguageconquers.model.dto.DepartamentoDTO;
import com.lenguageconquers.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private DepartamentoMapper departamentoMapper;

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> listar(){
        List<Departamento> departamentoList = departamentoService.listarDepartamentos();
        List<DepartamentoDTO> departamentoDTOS = departamentoMapper.listDepartamentoToListDepartamentoDTO(departamentoList);
        for (Departamento d: departamentoList) {
            DepartamentoDTO departamentoDTO = new DepartamentoDTO();
            departamentoDTO.setIdDepartamento(d.getIdDepartamento());
            departamentoDTO.setNombreDepartamento(d.getNombreDepartamento());
            departamentoDTO.setIdFacultad(d.getFacultad().getIdFacultad());
            departamentoDTOS.add(departamentoDTO);
        }
        return ResponseEntity.ok().body(departamentoDTOS);
    }

    @PostMapping("/registrarDepartamento")
    public ResponseEntity<String> guardar(@RequestBody DepartamentoDTO departamentoDTO){
        try {
            return new ResponseEntity<>(departamentoService.registrarDepartamento(departamentoDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje,HttpStatus.BAD_REQUEST);
        }
    }
}
