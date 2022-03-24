package com.lenguageconquers.service;


import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;

import java.util.List;

public interface CursoEstudianteService {

    public String matricularCurso(CursoEstudianteDTO cursoEstudianteDTO);
    public void eliminarMatricula(Long idCursoEstudiante);
    public List<CursoEstudiante> listaCursosMatriculados();
}
