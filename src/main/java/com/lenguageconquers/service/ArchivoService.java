package com.lenguageconquers.service;

import com.lenguageconquers.model.dto.ArchivosDTO;

import java.util.List;

public interface ArchivoService {

    List<ArchivosDTO> listar() throws Exception;
    String subirArchivo(ArchivosDTO archivosDTO) throws Exception;
}
