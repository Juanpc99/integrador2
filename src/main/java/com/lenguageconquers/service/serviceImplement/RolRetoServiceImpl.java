package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.RetosDAO;
import com.lenguageconquers.dao.RolDAO;
import com.lenguageconquers.dao.RolRetoDAO;
import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.RolReto;
import com.lenguageconquers.model.dto.RetoDTO;
import com.lenguageconquers.model.dto.RolRetoDTO;
import com.lenguageconquers.service.RolRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Scope("singleton")
@Service
public class RolRetoServiceImpl implements RolRetoService {

    @Autowired
    private RolRetoDAO rolRetoDAO;

    @Autowired
    private RolDAO rolDAO;

    @Autowired
    private RetosDAO retosDAO;

    @Override
    public List<RolRetoDTO> buscar(Long idReto, Long idRol) throws Exception {
        if(!retosDAO.findById(idReto).isPresent()){
            throw new Exception("El id del reto no existe");
        }
        if(!rolDAO.findById(idRol).isPresent()){
            throw new Exception("El id del rol no existe");
        }
        List<RolReto> rolRetos = rolRetoDAO.buscarPorRolReto(idReto, idRol);
        List<RolRetoDTO> retoDTOList = mapeoFromRolReto(rolRetos);
        return retoDTOList;
    }

    private RolRetoDTO mapeoRolReto(RolReto rolReto){
        RolRetoDTO rolRetoDTO= new RolRetoDTO();
        rolRetoDTO.setIdRolReto(rolReto.getIdRolReto());
        rolRetoDTO.setIdReto(rolReto.getReto().getIdReto());
        rolRetoDTO.setIdRol(rolReto.getRol().getIdRol());
        return rolRetoDTO;
    }

    private RolReto mapeoRetoDTO(RolRetoDTO rolRetoDTO){
        RolReto rolReto= new RolReto();
        rolReto.setIdRolReto(rolRetoDTO.getIdRolReto());
        rolReto.setReto(retosDAO.findById(rolRetoDTO.getIdReto()).get());
        rolReto.setRol(rolDAO.findById(rolRetoDTO.getIdRol()).get());
        return rolReto;
    }


    private List<RolRetoDTO> mapeoFromRolReto(List<RolReto> rolRetos){
        List<RolRetoDTO> retoDTOList = new ArrayList<>();
        for (RolReto reto: rolRetos){
            RolRetoDTO retoDTO = mapeoRolReto(reto);
            retoDTOList.add(retoDTO);
        }
        return retoDTOList;
    }
}
