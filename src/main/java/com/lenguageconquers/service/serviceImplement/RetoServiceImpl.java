package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.EstadoDAO;
import com.lenguageconquers.dao.EstadoTipoDAO;
import com.lenguageconquers.dao.RetosDAO;
import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.dto.RetoDTO;
import com.lenguageconquers.service.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class RetoServiceImpl implements RetoService {

    @Autowired
    private RetosDAO retosDAO;

    @Autowired
    private EstadoDAO estadoDAO;

    @Autowired
    private EstadoTipoDAO estadoTipoDAO;


    @Override
    public String actualizarEstado(RetoDTO retoDTO) throws Exception {
            Reto reto = null;
            if(retoDTO.getIdReto() == null){
                throw new Exception("Debe ingresar el id del reto que desea actualizar");
            }
            Optional<Reto> retoBd = Optional.of(retosDAO.findById(retoDTO.getIdReto()).get());

            if(retoBd.isEmpty()){
                throw new Exception("No existe un reto con ese id");
            }
            if(retoDTO.getIdEstado() == null){
                throw new Exception("Debe ingresar el id del estado");
            }
            if(retoDTO.getIdEstado()<0){
                throw new Exception("El id del estado no puede ser menor a 0");
            }
            if(estadoDAO.findById(retoDTO.getIdEstado()).toString().equals("Optional.empty")){
                throw new Exception("No se encontro el id de estado, ingrense uno valido");
            }
            if(!estadoDAO.findById(retoDTO.getIdEstado()).get().getEstadoTipo().getIdEstadoTipo().equals(3L)){
                throw new Exception("Debe ingresar un id de estado que sea de tipo reto");
            }

            reto = retosDAO.findById(retoDTO.getIdReto()).get();
            reto.getCurso().getIdCurso();
            reto.getDescripcionReto();
            reto.getDescripcionReto();
            reto.getTituloReto();
            reto.getFechaInicio();
            reto.getFechaLimite();
            reto.getMaximoIntentos();
            reto.getMision().getIdMision();
            reto.setEstado(estadoDAO.findById(retoDTO.getIdEstado()).get());
            retosDAO.save(reto);
            return "Se actualizo el id del estado en el reto";

    }

    @Override
    public List<Reto> listar() {
        return retosDAO.findAll();
    }

    @Override
    public Reto findByIdReto(Long idReto) throws Exception {
        if(idReto == null){
            throw new Exception("Se debe ingresar el id del reto");
        }
        if(!retosDAO.findById(idReto).isPresent()){
            throw new Exception("No existe el reto");
        }
        return retosDAO.findById(idReto).get();
    }
}
