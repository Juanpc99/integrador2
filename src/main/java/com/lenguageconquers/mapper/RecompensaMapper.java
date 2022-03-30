package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Recompensa;
import com.lenguageconquers.model.dto.RecompensaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecompensaMapper {

    List<RecompensaDTO> listRecompensaToRecompensaDTO(List<Recompensa> recompensaList);
}
