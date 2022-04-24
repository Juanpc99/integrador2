package com.lenguageconquers.model.dto;


import java.io.Serializable;

public class RolDTO implements Serializable {


    private static final long serialVersionUID = -6298342616737631776L;

    private Long idRol;
    private String nombreRol;

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
