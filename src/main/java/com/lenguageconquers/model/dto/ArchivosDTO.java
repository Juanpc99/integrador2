package com.lenguageconquers.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ArchivosDTO implements Serializable {


    private static final long serialVersionUID = -6890423043030984873L;
    private Long idArchivo;
    private String archivo;
    private Date fechaCreacion;
    private String titulo;
    private Long idProfesor;
    private Long idCurso;

    public Long getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Long idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }
}
