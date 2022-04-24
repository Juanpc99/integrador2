package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Grupos;
import com.lenguageconquers.model.dto.GruposDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrupoMapper {
    List<GruposDTO> listGrupoToGrupoDTO(List<Grupos> grupos);
}
