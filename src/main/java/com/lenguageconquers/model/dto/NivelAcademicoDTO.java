package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Curso;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class NivelAcademicoDTO implements Serializable {


    private static final long serialVersionUID = 3678301764454427041L;

    private Long idNivelAcademico;
    private Long idCurso;
}
