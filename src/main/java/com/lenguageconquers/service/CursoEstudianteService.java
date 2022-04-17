package com.lenguageconquers.service;



import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;

import java.util.List;

public interface CursoEstudianteService {

    String matricularCurso(CursoEstudianteDTO cursoEstudianteDTO) throws Exception;
    void eliminarMatricula(Long idEstudiante, Long idCursoEstudiante);
    List<CursoEstudiante> listaCursosMatriculadosPorEstudiate(Long idEstudiante) throws Exception;
    List<CursoEstudiante> listaCursosMatriculados(Long idEstudiante, Long idCurso);
    List<CursoEstudianteDTO> listarPorIdEstudiante(Long idEstudiante) throws Exception;
   // @Query(nativeQuery = true)
    //CursoEstudiante buscarIdCursoYIdEstudiante(@Param("idCurso")Long idCurso, @Param("idEstudiante")Long idEstudiante);
}
