package com.lenguageconquers.service;


import com.lenguageconquers.model.Avatar;
import com.lenguageconquers.model.dto.AvatarDTO;

import java.util.List;

public interface AvatarService{

    public List<Avatar> listar();
    public String registrar(AvatarDTO avatarDTO) throws Exception;
    public Avatar actualizar(Avatar avatar);
    public void eliminar(Long idAvatar);
}
