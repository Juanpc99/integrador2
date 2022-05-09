package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.AvatarDAO;
import com.lenguageconquers.dao.EstudianteDAO;
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

    @Autowired
    private EstudianteDAO estudianteDAO;

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

    @Override
    public Avatar actualizar(Avatar avatar) throws Exception {
        if(!Validaciones.validExtensionImg(avatar.getImgAvatar())){
            throw new Exception("Debe ingresar una extension valida para la imagen");
        }
        return avatarDAO.save(avatar);
    }

    @Override
    public void eliminar(Long idAvatar) throws Exception {
        if(idAvatar == null){
            throw new Exception("El id del avatar es obligatorio");
        }
        if(avatarDAO.existsById(idAvatar) == false){
            throw new Exception("No se encontro el avatar con ese id");
        }
        if(!estudianteDAO.findByIdAvatar(idAvatar).isEmpty()){
            throw new Exception("No se puede eliminar el avatar porque esta siendo uilizado por un estudiante");
        }

        avatarDAO.deleteById(idAvatar);
    }


    @Override
    public List<Avatar> listar() {
        List<Avatar> avatares = avatarDAO.findAll();
        return avatares;
    }
}
