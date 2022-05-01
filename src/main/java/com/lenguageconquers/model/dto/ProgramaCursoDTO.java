package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.Programa;

import java.io.Serializable;

public class ProgramaCursoDTO implements Serializable {

    private static final long serialVersionUID = 5331565474060893780L;

    private Long idProgramaCurso;
    private Programa programa;
    private Curso curso;

    public Long getIdProgramaCurso() {
        return idProgramaCurso;
    }

    public void setIdProgramaCurso(Long idProgramaCurso) {
        this.idProgramaCurso = idProgramaCurso;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
