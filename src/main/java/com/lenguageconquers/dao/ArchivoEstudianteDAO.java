package com.lenguageconquers.dao;

import com.lenguageconquers.model.ArchivoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArchivoEstudianteDAO extends JpaRepository<ArchivoEstudiante, Long> {

    @Query(value = "select * from archivo_estudiante where id_estudiante = ?1", nativeQuery = true)
    List<ArchivoEstudiante> findByIdEstudiante(Long idEstudiante) throws Exception;

}
