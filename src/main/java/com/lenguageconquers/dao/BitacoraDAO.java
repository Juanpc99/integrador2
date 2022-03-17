package com.lenguageconquers.dao;

import com.lenguageconquers.model.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BitacoraDAO extends JpaRepository<Bitacora, Long> {
}
