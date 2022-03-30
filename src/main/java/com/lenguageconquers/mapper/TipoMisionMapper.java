package com.lenguageconquers.mapper;

import com.lenguageconquers.model.TipoMision;
import com.lenguageconquers.model.dto.TipoMisionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoMisionMapper {

    List<TipoMisionDTO> listTipoMisionToListTipoMisionDTO(List<TipoMision> tipoMisions);
}
