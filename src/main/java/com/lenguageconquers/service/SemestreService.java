package com.lenguageconquers.service;


import com.lenguageconquers.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreService extends JpaRepository<Semestre,Long> {
}
