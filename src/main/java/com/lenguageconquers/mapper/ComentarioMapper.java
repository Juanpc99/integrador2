package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Comentario;
import com.lenguageconquers.model.dto.ComentarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {

    List<ComentarioDTO> listComentarioToListComentario(List<Comentario> comentarios);

}
