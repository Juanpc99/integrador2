package com.lenguageconquers.dao;

import com.lenguageconquers.model.Reto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RetosDAO extends JpaRepository<Reto, Long> {


    @Query(value = "SELECT *\n" +
            "FROM reto r\n" +
            "WHERE r.id_mision = ?1\n" +
            "AND r.id_curso = ?2", nativeQuery = true)
    List<Reto> findByIdCursoAndIdMision (Long idCurso, Long idMision) throws Exception;

    /*
    @Query(value = "select * from reto where id_reto = ?1 and es_grupal =true", nativeQuery = true)
    Reto findByIdRetoEsGrupal(Long idReto) throws Exception;

     */
}
