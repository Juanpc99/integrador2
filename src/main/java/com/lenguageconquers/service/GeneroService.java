package com.lenguageconquers.service;

import com.lenguageconquers.model.Genero;
import com.lenguageconquers.model.dto.GeneroDTO;

import java.util.List;

public interface GeneroService {

    String registrarGenero(GeneroDTO generoDTO) throws Exception;
    List<Genero> listaGeneros();
}
