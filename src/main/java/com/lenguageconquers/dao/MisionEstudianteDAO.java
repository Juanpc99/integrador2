package com.lenguageconquers.dao;

import com.lenguageconquers.model.MisionEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MisionEstudianteDAO extends JpaRepository<MisionEstudiante, Long> {

    @Query(value = "SELECT id_mision_estudiante, calificacion, id_nota, id_estudiante, id_mision, me.id_estado\n" +
            "\tFROM mision_estudiante me\n" +
            "\tINNER JOIN estado e on (e.id_estado = me.id_estado)\n" +
            "\tWHERE id_estudiante = ?1\n" +
            "\tAND id_mision = ?2 LIMIT 1", nativeQuery = true)
    MisionEstudiante findByIdEstudianteAndIdMision(Long idEstudiante, Long idMision) throws Exception;

}
