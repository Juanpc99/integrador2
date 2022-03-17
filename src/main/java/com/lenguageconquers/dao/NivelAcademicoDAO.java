package com.lenguageconquers.dao;

import com.lenguageconquers.model.NivelAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface NivelAcademicoDAO extends JpaRepository<NivelAcademico, Long> {
}
