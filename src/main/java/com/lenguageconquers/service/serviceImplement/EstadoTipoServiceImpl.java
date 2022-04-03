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
    public String crearEstadoTipo(EstadoTipoDTO estadoTipoDTO) throws Exception {
        EstadoTipo estadoTipo = new EstadoTipo();
        if(estadoTipoDTO.getNombreEstadoTipo() == null || estadoTipoDTO.getNombreEstadoTipo().trim().equals("")){
            throw new Exception("Debe ingresar el nombre del estado tipo");
        }
        if(estadoTipoDTO.getNombreEstadoTipo().length()>50){
            throw new Exception("El nombre del estado tipo es muy largo");
        }
        estadoTipo.setNombreEstadoTipo(estadoTipoDTO.getNombreEstadoTipo());
        estadoTipoDAO.save(estadoTipo);
        return "Se creo exitosamente el estado tipo";
    }

    @Override
    public List<EstadoTipo> listar() {
        return estadoTipoDAO.findAll();
    }

    @Override
    public EstadoTipo findByNombreEstadoTipo(String nombreEstadoTipo) throws Exception {
        if(nombreEstadoTipo == null || nombreEstadoTipo.equals("")){
            throw new Exception("Debe ingresar el nombre de un estado tipo");
        }
        EstadoTipo estadoTipoList = estadoTipoDAO.findByNombreEstadoTipo(nombreEstadoTipo.toLowerCase());
        return estadoTipoList;
    }


}
