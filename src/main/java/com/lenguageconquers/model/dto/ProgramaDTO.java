package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class ProgramaDTO implements Serializable {


    private static final long serialVersionUID = 6629284583016469242L;

    private Long idPrograma;
    private String nombrePrograma;
    private Long idDepartamento;

    public Long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
