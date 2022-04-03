package com.lenguageconquers.dao;

import com.lenguageconquers.model.EstadoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadoTipoDAO extends JpaRepository<EstadoTipo, Long> {

    //@Query(value = "select * from estado_tipo where nombre_estado_tipo =?1", nativeQuery = true)
    EstadoTipo findByNombreEstadoTipo(String nombreEstadoTipo);

}
