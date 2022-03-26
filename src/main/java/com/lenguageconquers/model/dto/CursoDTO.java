package com.lenguageconquers.model.dto;


import java.io.Serializable;
import java.util.Date;

public class CursoDTO implements Serializable {


    private static final long serialVersionUID = -8212670453394026321L;

    private Long idCurso;
    private String nombreCurso;
    private Date inicioCurso;
    private Date finCurso;
    private int cantidadEstudiantes;
    private String password;


    private Long idPrograma;
    private Long idEstado;

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Date getInicioCurso() {
        return inicioCurso;
    }

    public void setInicioCurso(Date inicioCurso) {
        this.inicioCurso = inicioCurso;
    }

    public Date getFinCurso() {
        return finCurso;
    }

    public void setFinCurso(Date finCurso) {
        this.finCurso = finCurso;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }
}
