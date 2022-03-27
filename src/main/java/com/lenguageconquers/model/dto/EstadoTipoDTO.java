package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class EstadoTipoDTO implements Serializable {


    private static final long serialVersionUID = -5969591222970061207L;

    private Long idEstadoTipo;
    private String nombreEstadoTipo;

    public Long getIdEstadoTipo() {
        return idEstadoTipo;
    }

    public void setIdEstadoTipo(Long idEstadoTipo) {
        this.idEstadoTipo = idEstadoTipo;
    }

    public String getNombreEstadoTipo() {
        return nombreEstadoTipo;
    }

    public void setNombreEstadoTipo(String nombreEstadoTipo) {
        this.nombreEstadoTipo = nombreEstadoTipo;
    }
}
