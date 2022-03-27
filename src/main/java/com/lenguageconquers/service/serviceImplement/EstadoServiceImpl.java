package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.EstadoDAO;
import com.lenguageconquers.dao.EstadoTipoDAO;
import com.lenguageconquers.model.Estado;
import com.lenguageconquers.model.dto.EstadoDTO;
import com.lenguageconquers.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoDAO estadoDAO;

    @Autowired
    private EstadoTipoDAO estadoTipoDAO;


    @Override
    public String crearEstado(EstadoDTO estadoDTO) {
       try{
           Estado estado = new Estado();
           estado.setNombreEstado(estadoDTO.getNombreEstado());
           estado.setEstadoTipo(estadoTipoDAO.findById(estadoDTO.getIdEstadoTipo()).get());
           estadoDAO.save(estado);
           return "Se creo exitosamente el estado";
       }catch (Exception e){
           return e.getMessage();
       }
    }

    @Override
    public List<Estado> listaEstados() {
        return estadoDAO.findAll();
    }

    @Override
    public List<Estado> listaEstadosTipo(Long idEstadoTipo) {
        return estadoDAO.findAll();
    }
}
