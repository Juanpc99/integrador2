package com.lenguageconquers.dao;

import com.lenguageconquers.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface CursoDAO extends JpaRepository<Curso, Long> {


    @Query(value = "select c.id_curso, c.nombre_curso, c.id_profesor, c.id_programa, c.inicio_curso, c.fin_curso, c.cantidad_estudiantes, c.id_estado, c.password \n" +
            "FROM estudiante e inner join curso c on (e.id_programa = c.id_programa) \n " +
            "where e.id_estudiante=?1", nativeQuery = true)
    List<Curso> findByIdEstudianteCursoConProgramaIgual(Long idEstudiante) throws Exception;

    @Query(value = "select  c.id_curso, c.nombre_curso, c.id_profesor, c.id_programa, c.inicio_curso, c.fin_curso, c.cantidad_estudiantes, c.id_estado, c.password  \n" +
            "from facultad f\n" +
            "inner join departamento d on (f.id_facultad = d.id_facultad)\n" +
            "inner join programa p on (p.id_departamento = d.id_departamento)\n" +
            "inner join curso c on (c.id_programa = p.id_programa) \n" +
            "where f.id_facultad = ?1", nativeQuery = true)
    List<Curso> findByIdFacultad(Long idFacultad) throws Exception;

    @Query(value = "select  c.id_curso, c.nombre_curso, c.id_profesor, c.id_programa, c.inicio_curso, c.fin_curso, c.cantidad_estudiantes, c.id_estado, c.password  \n" +
            "from facultad f\n" +
            "inner join departamento d on (f.id_facultad = d.id_facultad)\n" +
            "inner join programa p on (p.id_departamento = d.id_departamento)\n" +
            "inner join curso c on (c.id_programa = p.id_programa)\n" +
            "where f.id_facultad = ?1\n" +
            "and id_estado = ?2" , nativeQuery = true)
    List<Curso> findByIdFacultadAndIdEstado(Long idFacultad, Long idEstado) throws Exception;

    @Query(value = "SELECT * \n" +
            "FROM curso_estudiante ce\n" +
            "INNER JOIN curso c on (c.id_curso = ce.id_curso)\n" +
            "INNER JOIN reto r on (r.id_curso = c.id_curso)\n" +
            "WHERE ce.id_estudiante = ?1\n" +
            "AND c.id_curso = ?2", nativeQuery = true)
    List<Curso> findByIdEstudianteAndIdCUrso(Long idEstudiante, Long idCurso) throws Exception;

    @Query(value = "SELECT * \n" +
            "FROM curso_estudiante ce\n" +
            "INNER JOIN curso c on (c.id_curso = ce.id_curso)\n" +
            "INNER JOIN reto r on (r.id_curso = c.id_curso)\n" +
            "WHERE ce.id_estudiante = ?1\n" +
            "AND c.id_curso = ?2\n" +
            "AND r.id_estado = 2", nativeQuery = true)
    List<Curso> findByIdEstudianteAndIdCUrsoAndEstadoTerminado(Long idEstudiante, Long idCurso) throws Exception;



}
