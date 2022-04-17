package com.lenguageconquers.model.dto;



import java.io.Serializable;
import java.util.Date;

public class CursoEstudianteDTO implements Serializable {


    private static final long serialVersionUID = 86041570815902783L;

    private Long idCursoEstudiante;
    private Long idCurso;
    private Long idEstudiante;
    private Double puntaje_estudiante;
    private Long nivel;

//    private String nombreCurso;
//    private Date inicioCurso;
//    private Date finCurso;
//    private int cantidadEstudiantes;
//    private String password;


//    private Long idPrograma;
//    private Long idEstado;
//    private Long idProfesor;
//    private String correoProfesor;




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

    public Double getPuntaje_estudiante() {
        return puntaje_estudiante;
    }

    public void setPuntaje_estudiante(Double puntaje_estudiante) {
        this.puntaje_estudiante = puntaje_estudiante;
    }

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    //    public String getNombreCurso() {
//        return nombreCurso;
//    }
//
//    public void setNombreCurso(String nombreCurso) {
//        this.nombreCurso = nombreCurso;
//    }
//
//    public Date getInicioCurso() {
//        return inicioCurso;
//    }
//
//    public void setInicioCurso(Date inicioCurso) {
//        this.inicioCurso = inicioCurso;
//    }
//
//    public Date getFinCurso() {
//        return finCurso;
//    }
//
//    public void setFinCurso(Date finCurso) {
//        this.finCurso = finCurso;
//    }
//
//    public int getCantidadEstudiantes() {
//        return cantidadEstudiantes;
//    }
//
//    public void setCantidadEstudiantes(int cantidadEstudiantes) {
//        this.cantidadEstudiantes = cantidadEstudiantes;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

//    public Long getIdPrograma() {
//        return idPrograma;
//    }
//
//    public void setIdPrograma(Long idPrograma) {
//        this.idPrograma = idPrograma;
//    }
//
//    public Long getIdEstado() {
//        return idEstado;
//    }
//
//    public void setIdEstado(Long idEstado) {
//        this.idEstado = idEstado;
//    }
//
//    public Long getIdProfesor() {
//        return idProfesor;
//    }
//
//    public void setIdProfesor(Long idProfesor) {
//        this.idProfesor = idProfesor;
//    }
//
//    public String getCorreoProfesor() {
//        return correoProfesor;
//    }
//
//    public void setCorreoProfesor(String correoProfesor) {
//        this.correoProfesor = correoProfesor;
//    }
}
