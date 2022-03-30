package com.lenguageconquers.mapper;

import com.lenguageconquers.model.ArchivoEstudiante;
import com.lenguageconquers.model.dto.ArchivosEstudianteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArchivoEstudianteMapper {

    List<ArchivosEstudianteDTO> listArchivoEstudianteToArchivoEstudianteDTO(List<ArchivoEstudiante> archivoEstudiantes);

}
