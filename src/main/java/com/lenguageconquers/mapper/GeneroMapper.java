package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Genero;
import com.lenguageconquers.model.dto.GeneroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GeneroMapper {

    GeneroMapper INSTANCE = Mappers.getMapper(GeneroMapper.class);

    List<GeneroDTO> listGeneroToListGeneroDTO(List<Genero> generoList);
}
