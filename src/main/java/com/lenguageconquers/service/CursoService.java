package com.lenguageconquers.service;


import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.dto.CursoDTO;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CursoService{


    /**
     * @param password
     * @return
     */
    List<Curso> findByPassword(@Param("password") String password);

    /**
     *
     * @param idProfesor
     * @return
     */
    List<Curso> findByProfesor(@Param("idProfesor") Integer idProfesor);

    //CursoDTO findByIdCurso(Long idCurso);
    public String registrarCurso(CursoDTO cursoDTO);
    List<Curso> listaCursos();

}
