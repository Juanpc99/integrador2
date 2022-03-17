package com.lenguageconquers.model.dto;

import java.io.Serializable;
import java.util.Date;

public class RetoDTO implements Serializable {


    private static final long serialVersionUID = -7804630615080049852L;

    private Long idReto;
    private Date fechaLimite;
    private Date fechaInicio;
    private String descripcionReto;
    private String tituloReto;
    private Long maximoIntentos;
}
