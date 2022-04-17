package com.lenguageconquers.service;

import com.lenguageconquers.model.RetoEstudiante;
import com.lenguageconquers.model.dto.RetoEstudianteDTO;

import java.util.List;

public interface RetoEstudianteService {

    String crearRetoEstudiante(RetoEstudianteDTO retoEstudianteDTO) throws Exception;
    List<RetoEstudiante> listar();

    Double puntajeReto(Long id_estudiante, Long id_curso, Long id_mision) throws Exception;

    Double puntajeMision (Long id_curso, Long id_estudiante, Long id_mision) throws Exception;

    String observacionReto (String observacion, Long idEstudiante, Long idReto) throws Exception;


}
