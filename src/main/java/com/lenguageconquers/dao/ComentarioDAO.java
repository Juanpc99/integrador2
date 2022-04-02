package com.lenguageconquers.dao;

import com.lenguageconquers.model.Comentario;
import com.lenguageconquers.model.dto.ComentarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioDAO  extends JpaRepository<Comentario,Long> {

    @Query(value = "SELECT r.id_reto, re.id_reto_estudiante, re.id_estudiante, p.id_profesor, co.comentarios FROM comentario co inner join  reto_estudiante re on (co.id_reto_estudiante = re.id_reto_estudiante) inner join  reto r on (re.id_reto = r.id_reto) inner join  curso c on (r.id_curso = c.id_curso) inner join  profesor p on (c.id_profesor = p.id_profesor) where co.id_reto_estudiante =?1", nativeQuery = true)
    List<Comentario> findByIdRetoEstudiante (Long idRetoEstudiante) throws Exception;

}
