package com.lenguageconquers.dao;

import com.lenguageconquers.model.RolEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RolEstudianteDAO extends JpaRepository<RolEstudiante, Long> {
}
