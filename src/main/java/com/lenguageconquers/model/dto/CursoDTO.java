package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Programa;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

public class CursoDTO implements Serializable {


    private static final long serialVersionUID = -8212670453394026321L;

    private Long idCurso;
    private String nombreCurso;
    private Date inicioCurso;
    private Date finCurso;
    private int cantidadEstudiantes;
    private String password;


    private Long idPrograma;
    private Long idEstado;
}
