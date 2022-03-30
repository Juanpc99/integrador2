package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Archivo;
import com.lenguageconquers.model.dto.ArchivosDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArchivoMapper {

    List<ArchivosDTO> listArchivoToListArchivoDTO(List<Archivo> archivoList);
}
