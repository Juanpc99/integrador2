package com.lenguageconquers.service;

import com.lenguageconquers.model.ArchivoEstudiante;
import com.lenguageconquers.model.dto.ArchivosEstudianteDTO;

import java.util.List;

public interface ArchivoEstudianteService {

    List<ArchivoEstudiante> listar();
    List<ArchivoEstudiante>  listarPorId(Long idEstudiante) throws Exception;
    String subirArchivoEstudiante(ArchivosEstudianteDTO archivosEstudianteDTO) throws Exception;
}
