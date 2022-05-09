package com.lenguageconquers.service;


import com.lenguageconquers.model.dto.ProgramaDTO;

import java.util.List;

public interface ProgramaService {

    String crearPrograma(ProgramaDTO programaDTO) throws Exception;
    List<ProgramaDTO> listaProgramasPorDepartamento(Long idDepartamento) throws Exception;
}
