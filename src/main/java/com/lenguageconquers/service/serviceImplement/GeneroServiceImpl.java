package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.GeneroDAO;
import com.lenguageconquers.model.Genero;
import com.lenguageconquers.model.dto.GeneroDTO;
import com.lenguageconquers.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroDAO generoDAO;


    @Override
    public String registrarGenero(GeneroDTO generoDTO) {
        try{
            Genero genero = new Genero();
            genero.setNombreGenero(generoDTO.getNombreGenero());
            generoDAO.save(genero);
            return "Se creo exitosamente el genero";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Genero> listaGeneros() {
        return generoDAO.findAll();
    }
}
