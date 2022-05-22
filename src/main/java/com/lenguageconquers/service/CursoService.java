package com.lenguageconquers.service;


import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.dto.CursoDTO;

import java.util.List;

public interface CursoService{



    //CursoDTO findByIdCurso(Long idCurso);
    public String registrarCurso(CursoDTO cursoDTO) throws Exception;


    List<CursoDTO> listaCursos() throws Exception;

    CursoDTO findById(Long idCurso, Long idEstudiante) throws Exception;

    List<CursoDTO> encontrarPorIdEstudianteCursosConProgramaIgual(Long idEstudiante) throws Exception;

    List<CursoDTO> encontrarPorIdFacultad(Long idFacultad) throws Exception;

    List<CursoDTO> encontrarPorIdFacultadeIdEstado(Long idFacultad, Long idEstado) throws Exception;

    Integer progresoCurso(Long idEstudiante, Long idCurso) throws Exception;

}
