package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.dto.RetoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RetoMapper {

    List<RetoDTO> listRetoToListRetoDTO(List<Reto>retos);


}
