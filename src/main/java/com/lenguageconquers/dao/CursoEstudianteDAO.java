package com.lenguageconquers.dao;


import com.lenguageconquers.model.CursoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;





public interface CursoEstudianteDAO extends JpaRepository<CursoEstudiante, Long> {


    /*
    @Query(value = "SELECT * FROM CURSO_ESTUDIANTE ce INNER JOIN CURSO c ON (ce.ID_CURSO = c.ID_CURSO) WHERE ce.ID_CURSO =:idCursov AND ce.ID_ESTUDIANTE =:idEstudiante;",nativeQuery=true)
    CursoEstudiante buscarIdCursoyIdEstudiante(@Param("idCursov")Long idCursov, @Param("idEstudiante")Long idEstudiante);


     */


    @Query(value = "SELECT * FROM CURSO_ESTUDIANTE WHERE ID_CURSO =?1 And ID_ESTUDIANTE =?2", nativeQuery = true)
    CursoEstudiante buscarIdCursoyIdEstudiante(Long idCurso, Long idEstudiante) throws Exception;

}
