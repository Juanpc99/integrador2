package com.lenguageconquers.model.dto;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class RecursosDTO implements Serializable {


    private static final long serialVersionUID = -8268794220584678193L;

    private Long idRecurso;
    private String archivo;
    private String descripcion;
    private int descargas;
    private Date fechaCreacion;
}
