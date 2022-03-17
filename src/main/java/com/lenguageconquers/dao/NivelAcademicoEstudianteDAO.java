package com.lenguageconquers.dao;

import com.lenguageconquers.model.NivelAcademicoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface NivelAcademicoEstudianteDAO extends JpaRepository<NivelAcademicoEstudiante, Long> {
}
