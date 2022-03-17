package com.lenguageconquers.dao;

import com.lenguageconquers.model.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FacultadDAO extends JpaRepository<Facultad, Long> {
}
