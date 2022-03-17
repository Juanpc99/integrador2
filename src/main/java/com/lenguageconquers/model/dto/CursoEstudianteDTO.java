package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.Estudiante;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class CursoEstudianteDTO implements Serializable {


    private static final long serialVersionUID = 86041570815902783L;

    private Long idCursoEstudiante;
    private Curso curso;

    private Long idEstudiante;
}
