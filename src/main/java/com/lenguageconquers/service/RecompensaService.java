package com.lenguageconquers.service;

import com.lenguageconquers.model.Recompensa;
import com.lenguageconquers.model.dto.RecompensaDTO;

import java.util.List;

public interface RecompensaService {

    String crearRecompensa(RecompensaDTO recompensaDTO);
    List<Recompensa> listar();
}
