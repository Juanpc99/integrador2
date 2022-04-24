package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class RolRetoDTO implements Serializable {


    private static final long serialVersionUID = 5156806072636857730L;

    private Long idRolReto;
    private Long idReto;
    private Long idRol;

    public Long getIdRolReto() {
        return idRolReto;
    }

    public void setIdRolReto(Long idRolReto) {
        this.idRolReto = idRolReto;
    }

    public Long getIdReto() {
        return idReto;
    }

    public void setIdReto(Long idReto) {
        this.idReto = idReto;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
}
