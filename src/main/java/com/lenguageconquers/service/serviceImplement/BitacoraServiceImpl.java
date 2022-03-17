package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.BitacoraDAO;
import com.lenguageconquers.model.Bitacora;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class BitacoraServiceImpl implements BitacoraService {

    @Autowired
    private BitacoraDAO bitacoraDAO;

   /** @Override
    public Bitacora registrar(Bitacora bitacora) {
        return bitacoraDAO.save(bitacora);
    }

    @Override
    public Bitacora modificar(Bitacora bitacora) {
        return bitacoraDAO.save(bitacora);
    }

    @Override
    public void eliminar(int id) {
        //bitacoraDAO.delete(id);
    }

    @Override
    public Bitacora listarId(int id) {
        return null;
        //return bitacoraDAO.findOne(id);
    }

    @Override
    public List<Bitacora> listar() {
        return bitacoraDAO.findAll();
    }
    */
}
