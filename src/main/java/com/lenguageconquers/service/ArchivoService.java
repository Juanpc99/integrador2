package com.lenguageconquers.service;

import com.lenguageconquers.model.Archivo;
import com.lenguageconquers.model.dto.ArchivosDTO;

import java.util.List;

public interface ArchivoService {

    List<Archivo> listar();
    String subirArchivo(ArchivosDTO archivosDTO);
}
