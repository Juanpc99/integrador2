package com.lenguageconquers.model.dto;


import java.io.Serializable;

public class FacultadDTO implements Serializable {


    private static final long serialVersionUID = -8343584706336310657L;

    private Long idFacultad;
    private String nombreFacultad;

    public Long getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Long idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }
}
