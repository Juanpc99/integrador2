package com.lenguageconquers.dao;

import com.lenguageconquers.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DepartamentoDAO extends JpaRepository<Departamento, Long> {
}
