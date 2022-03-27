package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.EstadoTipoDAO;
import com.lenguageconquers.model.EstadoTipo;
import com.lenguageconquers.model.dto.EstadoTipoDTO;
import com.lenguageconquers.service.EstadoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class EstadoTipoServiceImpl implements EstadoTipoService {

    @Autowired
    private EstadoTipoDAO estadoTipoDAO;

    @Override
    public String crearEstadoTipo(EstadoTipoDTO estadoTipoDTO) {
        try {
            EstadoTipo estadoTipo = new EstadoTipo();
            estadoTipo.setNombreEstadoTipo(estadoTipoDTO.getNombreEstadoTipo());
            estadoTipoDAO.save(estadoTipo);
            return "Se creo exitosamente el estado tipo";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<EstadoTipo> listar() {
        return estadoTipoDAO.findAll();
    }
}
