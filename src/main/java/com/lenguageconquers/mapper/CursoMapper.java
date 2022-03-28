package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.dto.CursoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    //CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    @Named(value = "listCursoToListCursoDTO")
    @Mapping(source = "programa.idPrograma", target = "idPrograma")
    @Mapping(source = "profesor.idProfesor", target = "idProfesor")
    @Mapping(source = "curso.idCurso", target = "idCurso")
    List<CursoDTO> listCursoToListCursoDTO(List<Curso> listaCursos);

    @Mapping(source = "programa.idPrograma", target = "idPrograma")
    //@Mapping(source = "profesor.correoProfesor", target = "correoProfesor")
    @Mapping(source = "curso.idCurso", target = "idCurso")
    CursoDTO cursoToCursoDTO(Curso curso);
}
