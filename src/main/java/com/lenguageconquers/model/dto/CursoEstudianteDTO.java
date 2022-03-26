package com.lenguageconquers.model.dto;



import java.io.Serializable;

public class CursoEstudianteDTO implements Serializable {


    private static final long serialVersionUID = 86041570815902783L;

    private Long idCursoEstudiante;
    private Long idCurso;
    private Long idEstudiante;




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


}
