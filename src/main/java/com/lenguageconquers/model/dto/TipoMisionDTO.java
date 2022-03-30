package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class TipoMisionDTO implements Serializable {

    private static final long serialVersionUID = 733414799673763578L;

    private Long idTipoMision;
    private String descripcionTipo;

    public Long getIdTipoMision() {
        return idTipoMision;
    }

    public void setIdTipoMision(Long idTipoMision) {
        this.idTipoMision = idTipoMision;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
}
