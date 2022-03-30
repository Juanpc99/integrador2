package com.lenguageconquers.service;

import com.lenguageconquers.model.RetoEstudiante;
import com.lenguageconquers.model.dto.RetoEstudianteDTO;

import java.util.List;

public interface RetoEstudianteService {

    String crearRetoEstudiante(RetoEstudianteDTO retoEstudianteDTO);
    List<RetoEstudiante> listar();
}
