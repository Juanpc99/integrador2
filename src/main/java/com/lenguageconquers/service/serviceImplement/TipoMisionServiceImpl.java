package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.TipoMisionDAO;
import com.lenguageconquers.model.TipoMision;
import com.lenguageconquers.model.dto.TipoMisionDTO;
import com.lenguageconquers.service.TipoMisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class TipoMisionServiceImpl implements TipoMisionService {

    @Autowired
    private TipoMisionDAO tipoMisionDAO;

    @Override
    public String crearTipoMision(TipoMisionDTO tipoMisionDTO) throws Exception {
        TipoMision tipoMision = new TipoMision();
        if(tipoMisionDTO.getDescripcionTipo() == null){
            throw new Exception("Se debe ingresar una descripcion");
        }
        if(tipoMisionDTO.getDescripcionTipo().length() >200){
            throw new Exception("La descripcion es muy larga");
        }
        tipoMision.setDescripcionTipo(tipoMisionDTO.getDescripcionTipo());
        tipoMisionDAO.save(tipoMision);
        return "Se creo exitosamente el tipo mision";
    }

    @Override
    public List<TipoMision> listar() {
        return tipoMisionDAO.findAll();
    }
}
