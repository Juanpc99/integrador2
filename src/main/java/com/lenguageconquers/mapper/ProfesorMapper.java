package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Profesor;
import com.lenguageconquers.model.dto.ProfesorDTO;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ProfesorMapper {
    List<ProfesorDTO> listProfesorToListProfesorDTO(List<Profesor> profesorList);
}
