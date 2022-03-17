package com.lenguageconquers.dao;

import com.lenguageconquers.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivoDAO extends JpaRepository<Archivo, Long> {
}
