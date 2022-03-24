package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.AvatarDAO;
import com.lenguageconquers.model.Avatar;
import com.lenguageconquers.model.dto.AvatarDTO;
import com.lenguageconquers.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class AvatarServiceImpl implements AvatarService {

    @Autowired
    private AvatarDAO avatarDAO;

    @Override
    public String registrar(AvatarDTO avatarDTO) {
        try {
            Avatar avatar = new Avatar();
            avatar.setImgAvatar(avatarDTO.getImgAvatar());
            avatar.setNombreAvatar(avatarDTO.getNombreAvatar());
            avatarDAO.save(avatar);
            return "Se creo el avatar exitosamente";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public Avatar actualizar(Avatar avatar) {
            return avatarDAO.save(avatar);
    }

    @Override
    public void eliminar(Long idAvatar){
        avatarDAO.deleteById(idAvatar);
    }

    /**
    //TODO: VERIFICAR METODO
    @Override
    public Avatar listarId(int id) {
        return null;
        //return avatarDAO.findOne(id);
    }
*/
    @Override
    public List<Avatar> listar() {
        List<Avatar> avatares = avatarDAO.findAll();

        return avatares;
    }
}
