package com.lenguageconquers.dao;

import com.lenguageconquers.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CursoDAO extends JpaRepository<Curso, Long> {

    //TODO:SE DEBE DE CAMBIAR LOS NOMBRES DE LOS ATRIBUTOS DE LA CONSULTA

     @Query("SELECT c FROM Curso c WHERE c.password=:password")
     List<Curso> findByPassword(@Param("password") String password);
/*
	 @Query("SELECT c FROM Curso c WHERE c.profesor.idProfesor=:idProfesor")
	 List<Curso> findByProfesor(@Param("idProfesor") Integer idProfesor);
*/
}
