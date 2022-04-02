package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.MisionDAO;
import com.lenguageconquers.dao.NivelMisionDAO;
import com.lenguageconquers.dao.RecompensaDAO;
import com.lenguageconquers.dao.TipoMisionDAO;
import com.lenguageconquers.model.Mision;
import com.lenguageconquers.model.dto.MisionDTO;
import com.lenguageconquers.service.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class MisionServiceImpl implements MisionService {

    @Autowired
    private MisionDAO misionDAO;

    @Autowired
    private TipoMisionDAO tipoMisionDAO;

    @Autowired
    private NivelMisionDAO nivelMisionDAO;

    @Autowired
    private RecompensaDAO recompensaDAO;


    @Override
    public String cargarMision(MisionDTO misionDTO) {
        try{
            Mision mision = new Mision();
            if(misionDTO.getIdNivelMision() == null){
                throw new Exception("Se debe ingresar un id de nivel mision");
            }
            if(misionDTO.getIdNivelMision() <= 0){
                throw new Exception("Debe ingresar un id de nivel mision mayor a 0");
            }
            if(nivelMisionDAO.findById(misionDTO.getIdNivelMision()).toString().equals("Optional.empty")){
                throw new Exception("No existe el id del nivel mision, ingrese un id valido");
            }
            if(misionDTO.getIdTipoMision() == null){
                throw new Exception("Debe ingresar un id de tipo mision");
            }
            if(misionDTO.getIdTipoMision() <=0){
                throw new Exception("Debe ingresar un id de tipo mision mayor a 0");
            }
            if(tipoMisionDAO.findById(misionDTO.getIdTipoMision()).toString().equals("Optional.empty")){
                throw new Exception("NO existe el id de tipo mision, ingrese uno valido ");
            }
            if(misionDTO.getIdRecompensa() == null){
                throw new Exception("Debe ingresar un id de recompensa");
            }
            if(misionDTO.getIdRecompensa() <=0){
                throw new Exception("El id de recompensa debe ser mayor a 0");
            }
            if(recompensaDAO.findById(misionDTO.getIdRecompensa()).toString().equals("Optional.empty")){
                throw new Exception("No se encontro ese id de recompensa, ingrese uno valido");
            }
            if(misionDTO.getTituloMision() == null || misionDTO.getTituloMision().equals("")){
                throw new Exception("ingrese un titulo");
            }
            if(misionDTO.getTituloMision().length()> 100){
                throw new Exception("El titulo es muy largo");
            }
            if(misionDTO.getPuntajeMision() <0){
                throw new Exception("El puntaje no debe ser negativo");
            }

            mision.setNivelMision(nivelMisionDAO.findById(misionDTO.getIdNivelMision()).get());
            mision.setRecompensa(recompensaDAO.findById(misionDTO.getIdRecompensa()).get());
            mision.setTipoMision(tipoMisionDAO.findById(misionDTO.getIdTipoMision()).get());
            mision.setPuntajeMision(misionDTO.getPuntajeMision());
            mision.setTituloMision(misionDTO.getTituloMision());
            misionDAO.save(mision);
            return "Se cargo exitosamente la mision";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Mision> listarMisiones() {
        return misionDAO.findAll();
    }
}
