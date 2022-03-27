package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Departamento;
import com.lenguageconquers.model.dto.DepartamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {
    DepartamentoMapper INSTANCE = Mappers.getMapper(DepartamentoMapper.class);

    @Mapping(source = "idDepartamento", target = "idDepartamento")
    List<DepartamentoDTO> listDepartamentoToListDepartamentoDTO(List<Departamento> departamentoList);
}
