package com.lenguageconquers.service;

import com.lenguageconquers.model.Profesor;
import com.lenguageconquers.model.dto.ProfesorDTO;

import java.util.List;

public interface ProfesorService {

    String registarProfesor(ProfesorDTO profesorDTO);
    List<Profesor> listarProfesores();
}
