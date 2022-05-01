package com.lenguageconquers.dao;


import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.Mision;
import com.lenguageconquers.model.MisionEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CursoEstudianteDAO extends JpaRepository<CursoEstudiante, Long> {


    /*
    @Query(value = "SELECT * FROM CURSO_ESTUDIANTE ce INNER JOIN CURSO c ON (ce.ID_CURSO = c.ID_CURSO) WHERE ce.ID_CURSO =:idCursov AND ce.ID_ESTUDIANTE =:idEstudiante;",nativeQuery=true)
    CursoEstudiante buscarIdCursoyIdEstudiante(@Param("idCursov")Long idCursov, @Param("idEstudiante")Long idEstudiante);
     */


    @Query(value = "SELECT * FROM CURSO_ESTUDIANTE WHERE ID_CURSO =?1 And ID_ESTUDIANTE =?2", nativeQuery = true)
    CursoEstudiante buscarIdCursoyIdEstudiante(Long idCurso, Long idEstudiante) throws Exception;

    @Query(value = "SELECT * FROM CURSO_ESTUDIANTE WHERE ID_ESTUDIANTE =?1", nativeQuery = true)
    List<CursoEstudiante> findByIdEstudiante(Long idEstudiante) throws Exception;

    @Query(value = "SELECT * FROM curso_estudiante WHERE id_estudiante = ?1 AND id_curso = ?2 LIMIT 1", nativeQuery = true)
    CursoEstudiante findaByIdEstudianteAndIdCUrso (Long idEstudiante, Long idCurso) throws  Exception;

    @Query(value = "SELECT count(r.id_reto)\n" +
            "FROM reto r\n" +
            "INNER JOIN reto_estudiante re on (re.id_reto = r.id_reto)\n" +
            "INNER JOIN mision m on (m.id_mision = r.id_mision)\n" +
            "WHERE id_nivel_mision = ?1\n" +
            "AND id_estudiante =?2\n" +
            "AND id_curso = ?3\n" +
            "AND estado_tarea = 'Calificado'", nativeQuery = true)
    Double retosTerminados( Long nivel, Long idEstudiante, Long idCurso) throws Exception;

    @Query(value = "SELECT count(r.id_reto)\n" +
            "FROM reto r\n" +
            "INNER JOIN reto_estudiante re on (re.id_reto = r.id_reto)\n" +
            "INNER JOIN mision m on (m.id_mision = r.id_mision)\n" +
            "WHERE id_nivel_mision = ?1\n" +
            "AND id_estudiante =?2\n" +
            "AND id_curso = ?3", nativeQuery = true)
    Double totalRetos(Long nivel, Long idEstudiante, Long idCurso) throws Exception;

    @Query(value = "select *from curso_estudiante \n" +
            "where id_curso =?1\n" +
            "order by puntaje_estudiante desc limit 3", nativeQuery = true)
    List<CursoEstudiante> ranking(Long idCurso) throws Exception;

    @Query(value = "select nivel from curso_estudiante ce\n" +
            "inner join curso c on (ce.id_curso = c.id_curso)\n" +
            "inner join reto r on (c.id_curso = r.id_curso)\n" +
            "where r.id_reto = ?1 and ce.id_estudiante =?2 limit 1", nativeQuery = true)
    Integer nivelEstudiante (Long idReto, Long idEstudiante);


    @Query(value = "select id_mision_estudiante, calificacion, id_nota, id_estudiante, id_mision, id_estado from mision_estudiante\n" +
            "where  id_estado = 4", nativeQuery = true)
    List<Object[]> misionesTerminadasPorEstudiante (Long idEstudiante) throws Exception;

//    @Query(value = "select puntaje_estudiante from curso_estudiante\n" +
//            "where id_estudiante = ?1 AND id_curso = ?2;", nativeQuery = true)
//    Integer puntajeFinalEstudiante(Long idEstudiante, Long idCurso) throws Exception;
}
