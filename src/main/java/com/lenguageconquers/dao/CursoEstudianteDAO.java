package com.lenguageconquers.dao;

import com.lenguageconquers.model.CursoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CursoEstudianteDAO extends JpaRepository<CursoEstudiante, Long> {
}
