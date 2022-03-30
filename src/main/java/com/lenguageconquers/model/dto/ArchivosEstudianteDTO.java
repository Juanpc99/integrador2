package com.lenguageconquers.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ArchivosEstudianteDTO implements Serializable {


    private static final long serialVersionUID = 745554423196286418L;

    private Long idArchivoestudiante;
    private String descripcion;
    private Date fecaCreacion;
    private Long idArchivo;
    private Long idEstudiante;

    public Long getIdArchivoestudiante() {
        return idArchivoestudiante;
    }

    public void setIdArchivoestudiante(Long idArchivoestudiante) {
        this.idArchivoestudiante = idArchivoestudiante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecaCreacion() {
        return fecaCreacion;
    }

    public void setFecaCreacion(Date fecaCreacion) {
        this.fecaCreacion = fecaCreacion;
    }

    public Long getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Long idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
}
