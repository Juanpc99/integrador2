package com.lenguageconquers.dao;

import com.lenguageconquers.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorDAO extends JpaRepository<Profesor, Long> {
}
