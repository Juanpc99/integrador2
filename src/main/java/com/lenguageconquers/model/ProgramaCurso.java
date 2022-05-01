package com.lenguageconquers.model;

import javax.persistence.*;

@Entity
@Table(name = "programa_estudiante")
public class ProgramaCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programa_curso")
    private Long idProgramaCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
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
