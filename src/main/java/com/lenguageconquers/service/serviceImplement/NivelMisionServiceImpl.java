package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.NivelMisionDAO;
import com.lenguageconquers.model.NivelMision;
import com.lenguageconquers.model.dto.NivelMisionDTO;
import com.lenguageconquers.service.NivelMisionService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class NivelMisionServiceImpl implements NivelMisionService {


    @Autowired
    private NivelMisionDAO nivelMisionDAO;

    @Override
    public String crearNivelMision(NivelMisionDTO nivelMisionDTO) throws Exception {
        //TODO: NO SE ESTA GUARDANDO BIEN EL PUNTAJE MINIMO
        NivelMision nivelMision = new NivelMision();
        if(nivelMisionDTO.getNombreNivel() == null){
            throw new Exception("Se debe ingresar el nombre del nivel");
        }
        if(nivelMisionDTO.getNombreNivel().length() >100){
            throw new Exception("El nombre del nivel es muy largo");
        }
        if(nivelMisionDTO.getImgNivel() == null){
            throw new Exception("Debe ingresar la imagen del nivel");
        }
        if(!Validaciones.validExtensionImg(nivelMisionDTO.getImgNivel())){
            throw new Exception("Debe ingresar un formato valido para la imagen");
        }
        if(nivelMisionDTO.getImgNivel().length() >100){
            throw new Exception("El nombre del archivo es muy largo");
        }
        if(nivelMisionDTO.getMinimoPuntaje() <0){
            throw new Exception("No se puede ingresar un puntaje minimo negativo");
        }
        if(nivelMisionDTO.getPuntajeNivel() <0){
            throw new Exception("No se puede ingresar un puntaje negativo");
        }
        nivelMision.setImgNivel(nivelMisionDTO.getImgNivel());
        nivelMision.setNombreNivel(nivelMisionDTO.getNombreNivel());
        nivelMision.setPuntajeNivel(nivelMisionDTO.getPuntajeNivel());
        nivelMision.setMinimoPuntaje(nivelMisionDTO.getMinimoPuntaje());
        nivelMisionDAO.save(nivelMision);
        return "Se creo exitosamente el nivelMision";
    }

    @Override
    public List<NivelMision> listar() {
        return nivelMisionDAO.findAll();
    }
}
