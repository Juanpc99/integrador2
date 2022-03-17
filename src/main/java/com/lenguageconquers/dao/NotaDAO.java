package com.lenguageconquers.dao;

import com.lenguageconquers.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaDAO extends JpaRepository<Nota, Long> {
}
