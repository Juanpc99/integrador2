package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.CursoDAO;
import com.lenguageconquers.dao.GeneroDAO;
import com.lenguageconquers.dao.ProfesorDAO;
import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.Profesor;
import com.lenguageconquers.model.dto.ProfesorDTO;
import com.lenguageconquers.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorDAO profesorDAO;

    @Autowired
    private GeneroDAO generoDAO;

    @Autowired
    private CursoDAO cursoDAO;

    @Override
    public String registarProfesor(ProfesorDTO profesorDTO) {
        try{
            Profesor profesor = new Profesor();
            profesor.setNombreProfesor(profesorDTO.getNombreProfesor());
            profesor.setApellidoProfesor(profesorDTO.getApellidoProfesor());
            profesor.setCorreoProfesor(profesorDTO.getCorreoProfesor());
            profesor.setFechaNacimiento(profesorDTO.getFechaNacimiento());
            profesor.setFoto(profesorDTO.getFoto());
            profesor.setConfirmado(profesorDTO.isConfirmado());
            profesor.setGenero(generoDAO.findById(profesorDTO.getIdGenero()).get());
            System.out.println(profesorDTO.getFoto());
            System.out.println(profesor.getFoto());
            profesorDAO.save(profesor);
            return "Se creo exitosamente el profesor";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Profesor> listarProfesores() {
        return profesorDAO.findAll();
    }
}
