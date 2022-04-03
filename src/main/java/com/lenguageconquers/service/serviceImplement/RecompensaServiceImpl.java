package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.RecompensaDAO;
import com.lenguageconquers.model.Recompensa;
import com.lenguageconquers.model.dto.RecompensaDTO;
import com.lenguageconquers.service.RecompensaService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class RecompensaServiceImpl implements RecompensaService {

    @Autowired
    private RecompensaDAO recompensaDAO;

    @Override
    public String crearRecompensa(RecompensaDTO recompensaDTO) throws Exception {
        Recompensa recompensa = new Recompensa();
        if(recompensaDTO.getImgRecompensa() == null){
            throw new Exception("Se debe ingresar la imagen de la recompensa");
        }
        if(!Validaciones.validExtensionImg(recompensaDTO.getImgRecompensa())){
            throw new Exception("Se debe ingresar un formato valido de imagen");
        }
        if(recompensaDTO.getImgRecompensa().length() >100){
            throw new Exception("El nombre del archivo es muy largo");
        }
        if(recompensaDTO.getTituloRecompensa() == null){
            throw new Exception("Se debe ingresar un titulo de referencia de la recompensa");
        }
        if(recompensaDTO.getTituloRecompensa().length() >100){
            throw new Exception("El titulo de la recompensa es muy largo");
        }

        recompensa.setImgRecompensa(recompensaDTO.getImgRecompensa());
        recompensa.setTituloRecompensa(recompensaDTO.getTituloRecompensa());
        recompensaDAO.save(recompensa);
        return "Se creo exitosamente la recompensa";

    }

    @Override
    public List<Recompensa> listar() {
        return recompensaDAO.findAll();
    }
}
