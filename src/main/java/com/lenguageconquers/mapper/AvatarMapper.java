package com.lenguageconquers.mapper;

import com.lenguageconquers.model.Avatar;
import com.lenguageconquers.model.dto.AvatarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AvatarMapper {

    AvatarMapper INSTACE = Mappers.getMapper(AvatarMapper.class);

    /*
    @Mapping(source = "idAvatar",target = "idAvatar")
    @Mapping(source = "imgAvatar",target = "imgAvatar")
    @Mapping(source = "nombreAvatar",target = "nombreAvatar")
    AvatarDTO avatarToAvatarDTO(Avatar avatar);

     */

    @Mapping(source = "idAvatar",target = "idAvatar")
    List<AvatarDTO> listAvatarToListAvatarDTO(List<Avatar> listAvatar);


}
