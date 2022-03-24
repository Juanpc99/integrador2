package com.lenguageconquers.model.dto;


import com.lenguageconquers.model.Estudiante;

import java.io.Serializable;

public class CursoEstudianteDTO implements Serializable {


    private static final long serialVersionUID = 86041570815902783L;

    private Long idCursoEstudiante;
    private Long idCurso;
    private Long idEstudiante;

    private String nombreCurso;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String correoEstudiante;


    public Long getIdCursoEstudiante() {
        return idCursoEstudiante;
    }

    public void setIdCursoEstudiante(Long idCursoEstudiante) {
        this.idCursoEstudiante = idCursoEstudiante;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public String getCorreoEstudiante() {
        return correoEstudiante;
    }

    public void setCorreoEstudiante(String correoEstudiante) {
        this.correoEstudiante = correoEstudiante;
    }
}
