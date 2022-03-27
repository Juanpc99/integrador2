package com.lenguageconquers.service;


import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;

import java.util.List;

public interface CursoEstudianteService {

    public String matricularCurso(CursoEstudianteDTO cursoEstudianteDTO);
    public void eliminarMatricula(Long idEstudiante, Long idCursoEstudiante);
    public List<CursoEstudiante> listaCursosMatriculadosPorEstudiate(Long idEstudiante) throws Exception;
    public List<CursoEstudiante> listaCursosMatriculados(Long idEstudiante, Long idCurso);
}
