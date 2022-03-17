package com.lenguageconquers.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ArchivosDTO implements Serializable {


    private static final long serialVersionUID = -6890423043030984873L;
    private Long idArchivo;
    private String archivo;
    private Date fechaCreacion;
    private String titulo;
}
