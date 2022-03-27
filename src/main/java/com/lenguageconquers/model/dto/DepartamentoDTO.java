package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class DepartamentoDTO implements Serializable {


    private static final long serialVersionUID = -4940664531289544827L;

    private Long idDepartamento;
    private String nombreDepartamento;

    private Long idFacultad;

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Long getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Long idFacultad) {
        this.idFacultad = idFacultad;
    }
}
