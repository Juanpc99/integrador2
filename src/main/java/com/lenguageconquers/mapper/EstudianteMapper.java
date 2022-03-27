package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.dto.EstudianteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    List<EstudianteDTO> listEstudianteToListEstudianteDTO(List<Estudiante> estudianteList);
}
