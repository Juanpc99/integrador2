package com.lenguageconquers.dao;

import com.lenguageconquers.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProgramaDAO extends JpaRepository<Programa, Long> {
}
