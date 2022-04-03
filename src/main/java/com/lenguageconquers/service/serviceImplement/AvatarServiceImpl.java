package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.AvatarDAO;
import com.lenguageconquers.model.Avatar;
import com.lenguageconquers.model.dto.AvatarDTO;
import com.lenguageconquers.service.AvatarService;
import com.lenguageconquers.util.Validaciones;
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
    public String registrar(AvatarDTO avatarDTO) throws Exception {
        Avatar avatar = new Avatar();
        if(avatarDTO.getImgAvatar() == null ||
                avatarDTO.getImgAvatar().trim().equals("") ||
                Validaciones.isStringLenght(avatarDTO.getImgAvatar(), 80)){
                throw new Exception("Se debe ingresar una direccion de la imagen valida");
        }
        if(avatarDTO.getNombreAvatar() == null ||
                avatarDTO.getNombreAvatar().trim().equals("") ||
                Validaciones.isStringLenght(avatarDTO.getNombreAvatar(), 50)){
            throw new Exception("Se debe ingresar un nombre del avatar valido");
        }
        avatar.setImgAvatar(avatarDTO.getImgAvatar());
        avatar.setNombreAvatar(avatarDTO.getNombreAvatar());
        avatarDAO.save(avatar);
        return "Se creo el avatar exitosamente";
    }

    //TODO:NO ESTA COMPLETO
    @Override
    public Avatar actualizar(Avatar avatar) {
            return avatarDAO.save(avatar);
    }
    //TODO:NO ESTA COMPLETO
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
