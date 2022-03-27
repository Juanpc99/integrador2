package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Estado;
import com.lenguageconquers.model.dto.EstadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoMapper {
    EstadoMapper INSTANCE = Mappers.getMapper(EstadoMapper.class);
    List<EstadoDTO> listEstadoToListEstadoDTO(List<Estado> estadoList);
}
