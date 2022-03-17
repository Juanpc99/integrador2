package com.lenguageconquers.dao;

import com.lenguageconquers.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EstudianteDAO extends JpaRepository<Estudiante, Long> {


   Estudiante findOneByNombreEstudiante(String nombreEstudiante);

   //TODO: VERIFICAR TABLA RANKING ESTUDIANTE
   /*
	@Query("SELECT NEW com.languageconquers.model.dto.StudentRankingDto(s.nameStudent, s.lastnameStudent, s.nicknameStudent,"
			+ "s.semestreStudent, s.scoreStudent) FROM Student s WHERE s.course.idCourse =:idCourse order by  s.scoreStudent desc")
	List<StudentRankingDto> listarRankingByCurso(@Param("idCourse") int idCourse);
     */
}
