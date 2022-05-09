package com.lenguageconquers.service;


import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.dto.EstudianteDTO;

import java.util.List;


public interface EstudianteService{

    String crearEstudiante(EstudianteDTO estudianteDTO) throws Exception;
    List<EstudianteDTO> listaEstudiantes();
    List<EstudianteDTO> listaPorAvatares(Long idAvatar)throws Exception;

}
