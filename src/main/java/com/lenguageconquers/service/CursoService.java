package com.lenguageconquers.service;


import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.dto.CursoDTO;
import com.lenguageconquers.model.dto.CursoEstudianteDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface CursoService{



    //CursoDTO findByIdCurso(Long idCurso);
    public String registrarCurso(CursoDTO cursoDTO) throws Exception;
    List<Curso> listaCursos();

    CursoDTO findById(Long idCurso, Long idEstudiante) throws Exception;

    List<CursoDTO> encontrarPorIdEstudianteCursosConProgramaIgual(Long idEstudiante) throws Exception;

    List<CursoDTO> encontrarPorIdFacultad(Long idFacultad) throws Exception;

    List<CursoDTO> encontrarPorIdFacultadeIdEstado(Long idFacultad, Long idEstado) throws Exception;



}
