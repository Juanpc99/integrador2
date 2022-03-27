package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class EstadoDTO implements Serializable {


    private static final long serialVersionUID = -8829716816791844403L;

    private Long idEstado;
    private String nombreEstado;
    private Long idEstadoTipo;

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public Long getIdEstadoTipo() {
        return idEstadoTipo;
    }

    public void setIdEstadoTipo(Long idEstadoTipo) {
        this.idEstadoTipo = idEstadoTipo;
    }
}
