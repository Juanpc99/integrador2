package com.lenguageconquers.mapper;

import com.lenguageconquers.model.NivelMision;
import com.lenguageconquers.model.dto.NivelMisionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NivelMisionMapper {


    List<NivelMisionDTO> listNivelMisionToListNivelMisionDTO(List<NivelMision> nivelMisions);
}
