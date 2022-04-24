package com.lenguageconquers.mapper;

import com.lenguageconquers.model.RolReto;
import com.lenguageconquers.model.dto.RolRetoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolRetoMapper {
    List<RolRetoDTO> listRolRetoToRolRetoDto(List<RolReto> rolesRetos);
}
