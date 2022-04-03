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
    public String registrarGenero(GeneroDTO generoDTO) throws Exception {
        Genero genero = new Genero();
        if(generoDTO.getNombreGenero() == null || generoDTO.getNombreGenero().trim().equals("")){
            throw new Exception("Debe ingresar un nombre de genero");
        }
        if(generoDTO.getNombreGenero().length()>50){
            throw new Exception("El nombre del genero es muy largo");
        }
        genero.setNombreGenero(generoDTO.getNombreGenero());
        generoDAO.save(genero);
        return "Se creo exitosamente el genero";
    }

    @Override
    public List<Genero> listaGeneros() {
        return generoDAO.findAll();
    }
}
