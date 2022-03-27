package com.lenguageconquers.mapper;

import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.dto.CursoDTO;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoEstudianteMapper {

    CursoEstudianteMapper INSTANCE = Mappers.getMapper(CursoEstudianteMapper.class);

    /*
    @Mappings({
            @Mapping(source = "idCursoEstudiante", target = "idCursoEstudiante"),
            @Mapping(source = "idCurso", target = "idCurso"),
            @Mapping(source = "idEstudainte", target = "idEstudiente"),
    })

     */

    @Mapping(source = "idCursoEstudiante", target = "idCursoEstudiante")
    @Mapping(source = "idCurso", target = "idCurso")
    @Mapping(source = "idEstudiante", target = "idEstudiante")
    List<CursoEstudianteDTO> listCursoEstudianteToListCursoEstudianteDTO(List<CursoEstudiante> listCursoEstudiante);
    //@InheritInverseConfiguration
    //public CursoEstudianteDTO cursoEstudianteToCursoEstudianteDTO(CursoEstudiante cursoEstudiante);


}
