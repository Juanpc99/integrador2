package com.lenguageconquers.dao;

import com.lenguageconquers.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatDAO extends JpaRepository<Chat, Long> {

    @Query(value = "SELECT * FROM chat WHERE id_estudiante = ?1 AND id_profesor = ?2", nativeQuery = true)
    List<Chat> findByIdEstudianteAndIdProfesor(Long idEstudiante, Long idProfesor) throws Exception;
}
