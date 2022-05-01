package com.lenguageconquers.dao;

import com.lenguageconquers.model.Bitacora;
import com.lenguageconquers.model.dto.BitacoraDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BitacoraDAO extends JpaRepository<Bitacora, Long> {

    @Query(value = "select * from bitacoras where id_estudiante = ?1", nativeQuery = true)
    List<Bitacora> findByIdEstudiante(Long idEstudiante) throws Exception;

}
