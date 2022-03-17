package com.lenguageconquers.dao;

import com.lenguageconquers.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RolDAO extends JpaRepository<Rol, Long> {
}
