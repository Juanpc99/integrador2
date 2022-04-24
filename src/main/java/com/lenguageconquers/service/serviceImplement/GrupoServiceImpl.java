package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.GruposDAO;
import com.lenguageconquers.dao.RetoEstudianteDAO;
import com.lenguageconquers.dao.RolDAO;
import com.lenguageconquers.model.Grupos;
import com.lenguageconquers.model.dto.GruposDTO;
import com.lenguageconquers.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    private GruposDAO gruposDAO;

    @Autowired
    private RolDAO rolDAO;

    @Autowired
    private RetoEstudianteDAO retoEstudianteDAO;


    @Override
    public String crearGrupo(GruposDTO gruposDTO) throws Exception {
        Grupos grupos = new Grupos();
        if(gruposDTO.getNombreGrupo() == null || gruposDTO.getNombreGrupo().equals("")){
            throw new Exception("Debe ingresar un nombre para el grupo de trabajo");
        }
        if(gruposDTO.getNombreGrupo().length()>100){
            throw new Exception("El nombre del grupo es muy largo");
        }
        grupos.setNombreGrupo(gruposDTO.getNombreGrupo());
        gruposDAO.save(grupos);
        return "Se creo exitosamente el grupo";
    }

    @Override
    public String actualizarGrupo(GruposDTO gruposDTO) throws Exception {
        Grupos grupos = null;
        if(gruposDTO.getIdGrupo() == null){
            throw new Exception("Debe ingresar el id del grupo que desea editar");
        }
        if(!gruposDAO.existsById(gruposDTO.getIdGrupo())){
            throw new Exception("No existe un grupo con ese id");
        }
        if(gruposDTO.getNombreGrupo() == null || gruposDTO.getNombreGrupo().equals("")){
            throw new Exception("Debe ingresar un nombre para el grupo de trabajo");
        }
        if(gruposDTO.getNombreGrupo().length()>100){
            throw new Exception("El nombre del grupo es muy largo");
        }
        grupos = gruposDAO.findById(gruposDTO.getIdGrupo()).get();
        grupos.setNombreGrupo(gruposDTO.getNombreGrupo());
        gruposDAO.save(grupos);
        return "Se actualizo exitosamente el grupo";
    }

    @Override
    public List<Grupos> listar() {
        return gruposDAO.findAll();
    }
}
