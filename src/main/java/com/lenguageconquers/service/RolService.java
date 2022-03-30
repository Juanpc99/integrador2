package com.lenguageconquers.service;

import com.lenguageconquers.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolService extends JpaRepository<Rol,Long> {
}
