package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Facultad;
import com.lenguageconquers.model.dto.FacultadDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacultadMapper {

    FacultadMapper INSTANCE = Mappers.getMapper(FacultadMapper.class);

    @Mapping(source = "idFacultad", target = "idFacultad")
    List<FacultadDTO> listFacultadToListFacultadDTO(List<Facultad> facultadList);
}
