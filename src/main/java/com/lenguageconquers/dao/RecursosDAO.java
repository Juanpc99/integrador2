package com.lenguageconquers.dao;

import com.lenguageconquers.model.Recursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RecursosDAO extends JpaRepository<Recursos, Long> {
}
