package com.lenguageconquers.dao;

import com.lenguageconquers.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SemestreDAO extends JpaRepository<Semestre, Long> {
}
