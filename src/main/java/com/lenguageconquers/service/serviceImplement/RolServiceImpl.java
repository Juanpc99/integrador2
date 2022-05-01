package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.RetosDAO;
import com.lenguageconquers.dao.RolDAO;
import com.lenguageconquers.dao.RolRetoDAO;
import com.lenguageconquers.model.Rol;
import com.lenguageconquers.model.RolReto;
import com.lenguageconquers.model.dto.RolDTO;
import com.lenguageconquers.model.dto.RolRetoDTO;
import com.lenguageconquers.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("singleton")
@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDAO rolDAO;

    @Autowired
    private RolRetoDAO rolRetoDAO;

    @Autowired
    private RetosDAO retosDAO;

    @Override
    public String crearRol(String nombreRol, Long idReto) throws Exception {
        Rol rol = new Rol();
        RolReto rolReto = new RolReto();
        if(nombreRol == null || nombreRol.equals("")){
            throw new Exception("Debe ingresar el nombre del rol");
        }
        if(nombreRol.length()>50){
            throw new Exception("El nombre del rol es muy largo");
        }
        if(!retosDAO.existsById(idReto)){
            throw new Exception("No existe un reto con ese id, ingrese uno valido");
        }

        rol.setNombreRol(nombreRol);
        rolDAO.save(rol);
        rolReto.setReto(retosDAO.findById(idReto).get());
        rolReto.setRol(rolDAO.findById(rol.getIdRol()).get());
        try{
            rolRetoDAO.save(rolReto);

        }catch (Exception e){
            throw new Exception("No pudo ejecutar el save de rolreto");
        }
        return "Se creo exitosamente el rol y el rol_reto";

    }
}
