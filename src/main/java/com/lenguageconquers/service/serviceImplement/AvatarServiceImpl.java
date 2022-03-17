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

@Scope("singleton")
@Service
public class AvatarServiceImpl implements AvatarService {

    @Autowired
    private AvatarDAO avatarDAO;
    /**
    @Override
    public Avatar registrar(Avatar avatar) {
        return avatarDAO.save(avatar);
    }

    @Override
    public Avatar modificar(Avatar avatar) {
        return avatarDAO.save(avatar);
    }

    //TODO: VERIFICAR METODO DE ELIMINAR
    @Override
    public void eliminar(int id) {
       // avatarDAO.delete(id);
    }

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
