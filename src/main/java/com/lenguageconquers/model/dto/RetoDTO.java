package com.lenguageconquers.model.dto;

import java.io.Serializable;
import java.util.Date;

public class RetoDTO implements Serializable {


    private static final long serialVersionUID = -7804630615080049852L;

    private Long idReto;
    private Date fechaLimite;
    private Date fechaInicio;
    private String descripcionReto;
    private String tituloReto;
    private Long maximoIntentos;

    public Long getIdReto() {
        return idReto;
    }

    public void setIdReto(Long idReto) {
        this.idReto = idReto;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDescripcionReto() {
        return descripcionReto;
    }

    public void setDescripcionReto(String descripcionReto) {
        this.descripcionReto = descripcionReto;
    }

    public String getTituloReto() {
        return tituloReto;
    }

    public void setTituloReto(String tituloReto) {
        this.tituloReto = tituloReto;
    }

    public Long getMaximoIntentos() {
        return maximoIntentos;
    }

    public void setMaximoIntentos(Long maximoIntentos) {
        this.maximoIntentos = maximoIntentos;
    }
}
