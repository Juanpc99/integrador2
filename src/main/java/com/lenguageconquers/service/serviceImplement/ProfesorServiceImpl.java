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

import java.util.ArrayList;
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
            profesorDAO.save(profesor);
            return "Se creo exitosamente el profesor";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<ProfesorDTO> listarProfesores() {

        List<ProfesorDTO> profesorDTOS = mapeoForProfesor(profesorDAO.findAll());
        return profesorDTOS;
    }


    public ProfesorDTO mapeo(Profesor profesor){
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setNombreProfesor(profesor.getNombreProfesor());
        profesorDTO.setApellidoProfesor(profesor.getApellidoProfesor());
        profesorDTO.setCorreoProfesor(profesor.getCorreoProfesor());
        profesorDTO.setFechaNacimiento(profesor.getFechaNacimiento());
        profesorDTO.setConfirmado(profesor.isConfirmado());
        profesorDTO.setFoto(profesor.getFoto());
        profesorDTO.setIdGenero(profesor.getGenero().getIdGenero());
        return profesorDTO;
    }

    public List<ProfesorDTO> mapeoForProfesor(List<Profesor> profesorList){
        List<ProfesorDTO> profesorDTOS = new ArrayList<>();
        for(Profesor profesor: profesorList){
            ProfesorDTO profesorDTO = mapeo(profesor);
            profesorDTOS.add(profesorDTO);
        }
        return profesorDTOS;
    }
}
