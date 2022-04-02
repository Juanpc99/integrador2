package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.EstadoDAO;
import com.lenguageconquers.dao.EstadoTipoDAO;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.Estado;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;
import com.lenguageconquers.model.dto.EstadoDTO;
import com.lenguageconquers.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
           if(estadoDTO.getIdEstadoTipo() == null){
               throw new Exception("Se debe ingresar un id de tipo estado");
           }
           if(estadoDTO.getIdEstadoTipo()<0){
               throw new Exception("El id del tipo estado debe ser mayor a 0");
           }
           if(estadoTipoDAO.findById(estadoDTO.getIdEstadoTipo()).toString().equals("Optional.empty")){
               throw new Exception("No se encontro el id de tipo estado, ingrese uno valido");
           }
           if(estadoDTO.getNombreEstado() == null || estadoDTO.getNombreEstado().equals("")){
               throw new Exception("Debe ingresar un nombre");
           }
           if(estadoDTO.getNombreEstado().length()>50){
               throw new Exception("El nombre del estado es muy largo");
           }
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
    public List<Estado> listaPoridEstadoTipo(Long idEstadoTipo) throws Exception {
        List<Estado> estadoList = estadoDAO.findByIdEstadoTipo(idEstadoTipo);
        List<EstadoDTO> estadoDTOS = new ArrayList<>();
        for (Estado estado: estadoList) {
            EstadoDTO estadoDTO = new EstadoDTO();
            estadoDTO.setIdEstado(estado.getIdEstado());
            estadoDTO.setNombreEstado(estado.getNombreEstado());
            estadoDTO.setIdEstadoTipo(estado.getEstadoTipo().getIdEstadoTipo());
            estadoDTOS.add(estadoDTO);

        }
        return estadoList;
    }


}
