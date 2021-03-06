package com.lenguageconquers.controller;

import com.lenguageconquers.mapper.ArchivoEstudianteMapper;
import com.lenguageconquers.model.ArchivoEstudiante;
import com.lenguageconquers.model.dto.ArchivosEstudianteDTO;
import com.lenguageconquers.service.ArchivoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/archivoEstudiante")
public class ArchivoEstudianteController {

    @Autowired
    private ArchivoEstudianteService archivoEstudianteService;

    @Autowired
    private ArchivoEstudianteMapper archivoEstudianteMapper;

    @GetMapping
    public ResponseEntity<List<ArchivosEstudianteDTO>> listaDeArchivosEstudiantes(){
        List<ArchivoEstudiante> archivoEstudiantes = archivoEstudianteService.listar();
        List<ArchivosEstudianteDTO>archivosEstudianteDTOS = new ArrayList<>();
        for (ArchivoEstudiante archivoEstudiante: archivoEstudiantes) {
            ArchivosEstudianteDTO archivosEstudianteDTO = new ArchivosEstudianteDTO();
            archivosEstudianteDTO.setIdArchivoestudiante(archivoEstudiante.getIdArchivoestudiante());
            archivosEstudianteDTO.setIdEstudiante(archivoEstudiante.getIdArchivoestudiante());
            archivosEstudianteDTO.setIdArchivo(archivoEstudiante.getArchivo().getIdArchivo());
            archivosEstudianteDTO.setIdEstudiante(archivoEstudiante.getEstudiante().getIdEstudiante());
            archivosEstudianteDTO.setDescripcion(archivoEstudiante.getDescripcion());
            archivosEstudianteDTO.setFecaCreacion(archivoEstudiante.getFecaCreacion());
            archivosEstudianteDTOS.add(archivosEstudianteDTO);
        }
        return ResponseEntity.ok().body(archivosEstudianteDTOS);
    }

    @GetMapping("/listarPorEstudiante")
    public ResponseEntity<List<ArchivosEstudianteDTO>> listaDeArchivosPorEstudiantes(@RequestParam  Long idEstudiante) throws Exception {
        try{
            return new ResponseEntity<>(archivoEstudianteService.listarPorId(idEstudiante), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/crearArchivoEstudiante")
    public ResponseEntity<String> subirArchivo(@RequestBody ArchivosEstudianteDTO archivosEstudianteDTO){
        try {
            return new ResponseEntity<>(archivoEstudianteService.subirArchivoEstudiante(archivosEstudianteDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity<>(mensaje,HttpStatus.BAD_REQUEST);
        }
    }
}
