package com.lenguageconquers.service;


import com.lenguageconquers.model.Bitacora;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.dto.BitacoraDTO;

import java.util.List;

public interface BitacoraService {
    String guardarRegistro(BitacoraDTO bitacoraDTO) throws Exception;

    String actualizarRegistro(BitacoraDTO bitacoraDTO) throws Exception;

    List<BitacoraDTO> listaRegistros(Long idEstudiante) throws Exception;
}
