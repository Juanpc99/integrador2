package com.lenguageconquers.model.dto;

import java.io.Serializable;
import java.util.Date;

public class RetoEstudianteDTO implements Serializable {


    private static final long serialVersionUID = -5316554744966047706L;

    private Long idRetoEstudiante;
    private String nombreArchivo;
    private String urlArchivo;
    private String estadoTarea;
    private Date fechaSubida;
    private Long idReto;
    private Long idEstudiante;
    private Double calificacion;

    public Long getIdRetoEstudiante() {
        return idRetoEstudiante;
    }

    public void setIdRetoEstudiante(Long idRetoEstudiante) {
        this.idRetoEstudiante = idRetoEstudiante;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public Long getIdReto() {
        return idReto;
    }

    public void setIdReto(Long idReto) {
        this.idReto = idReto;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
}
