package com.lenguageconquers.service;

import com.lenguageconquers.model.RolReto;
import com.lenguageconquers.model.dto.RolRetoDTO;

import java.util.List;

public interface RolRetoService {

    List<RolRetoDTO> buscar(Long idReto, Long idRol) throws Exception;
}
