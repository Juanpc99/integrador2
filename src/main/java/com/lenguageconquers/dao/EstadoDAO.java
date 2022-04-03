package com.lenguageconquers.dao;


import com.lenguageconquers.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadoDAO extends JpaRepository<Estado, Long> {

    @Query(value = "SELECT * FROM ESTADO WHERE ID_ESTADO_TIPO =?1", nativeQuery = true)
    List<Estado> findByIdEstadoTipo(Long idEstadoT) throws Exception;


}
