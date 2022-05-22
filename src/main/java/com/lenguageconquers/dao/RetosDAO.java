package com.lenguageconquers.dao;

import com.lenguageconquers.model.Reto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RetosDAO extends JpaRepository<Reto, Long> {


    @Query(value = "SELECT id_reto, fecha_limite, id_estado , id_mision, id_curso, fecha_inicio, descripcion_reto, titulo_reto, maximo_intentos, es_grupal, cantidad_estudiantes_grupos\n" +
            "FROM reto r\n" +
            "WHERE r.id_mision = ?2\n" +
            "AND r.id_curso = ?1", nativeQuery = true)
    List<Reto> findByIdCursoAndIdMision (Long idCurso, Long idMision) throws Exception;

    @Query(value = "select id_curso_estudiante from \n" +
            "curso_estudiante ce\n" +
            "where ce.id_curso = ?1\n" +
            "AND nivel = 2", nativeQuery = true)
    List<Long> estudiantesPorCurso(Long idCUrso) throws Exception;
    /*
    @Query(value = "select * from reto where id_reto = ?1 and es_grupal =true", nativeQuery = true)
    Reto findByIdRetoEsGrupal(Long idReto) throws Exception;

     */
    @Query(value = "select * from reto where id_curso = ?1", nativeQuery = true)
    List<Reto> retosPorCurso(Long idCurso) throws Exception;
}
