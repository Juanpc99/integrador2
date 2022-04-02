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
    private int maximoIntentos;
    private Long idEstado;
    private Long idMision;
    private Long idCurso;

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

    public int getMaximoIntentos() {
        return maximoIntentos;
    }

    public void setMaximoIntentos(int maximoIntentos) {
        this.maximoIntentos = maximoIntentos;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdMision() {
        return idMision;
    }

    public void setIdMision(Long idMision) {
        this.idMision = idMision;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }
}
