package com.lenguageconquers.dao;

import com.lenguageconquers.model.Comentario;
import com.lenguageconquers.model.dto.ComentarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioDAO  extends JpaRepository<Comentario,Long> {

    @Query(value = "Select c.id_comentario, c.comentarios, c.id_reto_estudiante FROM comentario c\n" +
            "inner join reto_estudiante re on (re.id_reto_estudiante = c.id_reto_estudiante)\n" +
            "where re.id_estudiante =?1\n" +
            "and re.id_reto =?2", nativeQuery = true)
    List<Comentario> findByIdRetoEstudiante (Long idEstudiante, Long idReto) throws Exception;

}
