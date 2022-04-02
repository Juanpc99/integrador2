package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Mision;
import com.lenguageconquers.model.dto.MisionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MisionMapper {

    List<MisionDTO> listMisionToListMisionDTO(List<Mision> misions);
}
