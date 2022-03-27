package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class GeneroDTO implements Serializable {


    private static final long serialVersionUID = 2991869639620441731L;

    private Long idGenero;
    private String nombreGenero;

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
}
