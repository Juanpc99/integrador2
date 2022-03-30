package com.lenguageconquers.dao;

import com.lenguageconquers.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioDAO  extends JpaRepository<Comentario,Long> {
}
