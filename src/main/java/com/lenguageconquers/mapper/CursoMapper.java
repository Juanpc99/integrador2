package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.dto.CursoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    List<CursoDTO> listCursoToCursoDTO(List<Curso> listaCursos);
}
