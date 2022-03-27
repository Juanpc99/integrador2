package com.lenguageconquers.service;

import com.lenguageconquers.model.Programa;
import com.lenguageconquers.model.dto.ProgramaDTO;

import java.util.List;

public interface ProgramaService {

    String crearPrograma(ProgramaDTO programaDTO);
    List<Programa> listaProgramasPorDepartamento(Long idDepartamento);
}
