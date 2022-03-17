package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Facultad;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class DepartamentoDTO implements Serializable {


    private static final long serialVersionUID = -4940664531289544827L;

    private Long idDepartamento;
    private String nombreDepartamento;

    private Long idFacultad;

}
