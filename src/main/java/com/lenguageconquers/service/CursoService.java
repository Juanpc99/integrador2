package com.lenguageconquers.service;


import com.lenguageconquers.model.Curso;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

}
