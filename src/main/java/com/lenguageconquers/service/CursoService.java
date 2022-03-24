package com.lenguageconquers.service;


import com.lenguageconquers.model.Curso;
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

    Optional<Curso> findById(Long idCurso);

}
