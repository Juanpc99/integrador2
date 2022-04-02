package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.EstadoDAO;
import com.lenguageconquers.dao.RetosDAO;
import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.dto.RetoDTO;
import com.lenguageconquers.service.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("singleton")
@Service
public class RetoServiceImpl implements RetoService {

    @Autowired
    private RetosDAO retosDAO;

    @Autowired
    private EstadoDAO estadoDAO;


    @Override
    public String actualizarEstado(RetoDTO retoDTO) {
        try {
            Reto reto = new Reto();
            reto.setEstado(estadoDAO.findById(retoDTO.getIdEstado()).get());
            retosDAO.save(reto);

            return "Se actualizo el id del estado en el reto";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
