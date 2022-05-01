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
    String subirDeNivel (Long nivel, Long idEstudiante, Long idCurso) throws Exception;
    List<CursoEstudianteDTO> listarRanking(Long idCurso)throws Exception;
    Double notaFinal(Long idEstudiante, Long idCurso) throws Exception;
    Integer nivelEstudiante(Long idReto, Long idEstudiante);
    String matricularCurso2(Long idEstudiante, Long idCurso, String password) throws Exception;

}
