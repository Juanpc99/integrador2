package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Programa;
import com.lenguageconquers.model.dto.ProgramaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgramaMapper {
    ProgramaMapper INSTANCE = Mappers.getMapper(ProgramaMapper.class);

    List<ProgramaDTO> listProgramaToListProgramaDTO(List<Programa> programaList);
}
