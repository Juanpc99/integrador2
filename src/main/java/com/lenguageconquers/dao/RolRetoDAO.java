package com.lenguageconquers.dao;


import com.lenguageconquers.model.RolReto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolRetoDAO extends JpaRepository<RolReto, Long> {

    @Query(value = "select * from roles_reto where id_reto = ?1 and id_rol = ?2", nativeQuery = true)
    List<RolReto> buscarPorRolReto(Long idReto, Long idRol) throws Exception;
}
