package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.MisionMapper;
import com.lenguageconquers.model.Mision;
import com.lenguageconquers.model.dto.MisionDTO;
import com.lenguageconquers.service.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/misiones")
public class MisionController {

    @Autowired
    private MisionService misionService;

    @Autowired
    private MisionMapper misionMapper;

    @GetMapping
    public ResponseEntity<List<MisionDTO>> listar(){
        List<Mision> misions = misionService.listarMisiones();
        List<MisionDTO> misionDTOS = new ArrayList<>();
        for (Mision mision: misions) {
            MisionDTO misionDTO = new MisionDTO();
            misionDTO.setIdMision(mision.getIdMision());
            misionDTO.setIdNivelMision(mision.getNivelMision().getIdNivelMision());
            misionDTO.setIdTipoMision(mision.getTipoMision().getIdTipoMision());
            misionDTO.setIdRecompensa(mision.getRecompensa().getIdRecompensa());
            misionDTO.setTituloMision(mision.getTituloMision());
            misionDTO.setPuntajeMision(mision.getPuntajeMision());
            misionDTOS.add(misionDTO);
        }
        return ResponseEntity.ok().body(misionDTOS);
    }

    @PostMapping("/cargar")
    public ResponseEntity<String> cargar(@RequestBody MisionDTO misionDTO){
        try {
            return new ResponseEntity<>(misionService.cargarMision(misionDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
    }
}
