package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.NivelAcademico;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class NivelAcademicoEstudianteDTO implements Serializable {


    private static final long serialVersionUID = -4672078818870515561L;

    private Long idNivelAcadEstudiante;
    private Long idEstudiante;
    private Long idNivelAcademico;
}
