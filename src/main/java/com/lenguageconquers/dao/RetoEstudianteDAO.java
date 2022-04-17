package com.lenguageconquers.dao;

import com.lenguageconquers.model.RetoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RetoEstudianteDAO extends JpaRepository<RetoEstudiante, Long> {

    @Query(value = "SELECT id_reto_estudiante, calificacion, id_estudiante, r.id_reto, nombre_archivo, url_archivo, estado_tarea, fecha_subida \n" +
            "FROM RETO r\n" +
            "INNER JOIN reto_estudiante re on (r.id_reto = re.id_reto)\n" +
            "WHERE id_estudiante =?1 \n" +
            "AND r.id_curso =?2 \n" +
            "AND r.id_mision = ?3", nativeQuery = true)
    List<RetoEstudiante> puntosRetos (Long id_estudiante, Long id_curso, Long id_mision) throws Exception;

    @Query(value = "SELECT count(id_mision)\n" +
            "FROM reto r\n" +
            "WHERE id_curso = ?1\n" +
            "AND id_mision = ?2", nativeQuery = true)
    Double totalRetosPorCursoYMision(Long id_curso, Long id_mision) throws Exception;

    @Query(value = "SELECT  count(id_mision) \n" +
            "FROM reto r\n" +
            "INNER JOIN reto_estudiante re on (r.id_reto = re.id_reto)\n" +
            "WHERE estado_tarea = 'Calificado'\n" +
            "AND id_estudiante = ?1\n" +
            "AND id_curso = ?2\n" +
            "AND id_mision = ?3", nativeQuery = true)
    Double retosTerminadosPorMision(Long id_estudiante, Long id_curso, Long id_mision) throws Exception;

    @Query(value = "SELECT * FROM reto_estudiante re WHERE id_reto = ?1 AND id_estudiante = ?2 LIMIT 1", nativeQuery = true)
    RetoEstudiante findByIdEstudianteAndIdReto (Long idReto, Long idEstudiante) throws Exception;
}
