package com.lenguageconquers.mapper;

import com.lenguageconquers.model.RetoEstudiante;
import com.lenguageconquers.model.dto.RetoEstudianteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RetoEstudianteMapper {

    List<RetoEstudianteDTO> listRetoEstudianteToRetoEstudianteDTO(List<RetoEstudiante>retoEstudiantes);
}
