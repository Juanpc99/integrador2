package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Departamento;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ProgramaDTO implements Serializable {


    private static final long serialVersionUID = 6629284583016469242L;

    private Long idPrograma;
    private String nombrePrograma;
    private Long idDepartamento;
}
