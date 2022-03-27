package com.lenguageconquers.mapper;

import com.lenguageconquers.model.EstadoTipo;
import com.lenguageconquers.model.dto.EstadoTipoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoTipoMapper {

    EstadoTipoMapper INSTANCE = Mappers.getMapper(EstadoTipoMapper.class);

    List<EstadoTipoDTO> listEstadoTipoToListEstadoTipoDTO(List<EstadoTipo> estadoTipoList);
}
