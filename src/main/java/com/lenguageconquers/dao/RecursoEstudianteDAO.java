package com.lenguageconquers.dao;

import com.lenguageconquers.model.RecursoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RecursoEstudianteDAO extends JpaRepository<RecursoEstudiante, Long> {
}
