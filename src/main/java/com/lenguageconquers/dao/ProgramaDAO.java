package com.lenguageconquers.dao;

import com.lenguageconquers.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProgramaDAO extends JpaRepository<Programa, Long> {

    @Query(value = "select * from programa where id_departamento = ?1", nativeQuery = true)
    List<Programa> findByIdDepartamento(Long idDepartamento) throws Exception;
}
