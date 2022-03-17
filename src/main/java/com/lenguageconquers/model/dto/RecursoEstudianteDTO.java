package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.Recursos;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class RecursoEstudianteDTO implements Serializable {


    private static final long serialVersionUID = -3142947912121505582L;
    private Long idRecursoEstudiante;

    private Long idEstudiante;
    private Long idRecursos;

}
