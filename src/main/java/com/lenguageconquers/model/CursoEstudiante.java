package com.lenguageconquers.model;



import javax.persistence.*;

@Entity
@Table(name = "curso_estudiante")
public class CursoEstudiante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso_estudiante")
    private Long idCursoEstudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;


    public Long getIdCursoEstudiante() {
        return idCursoEstudiante;
    }

    public void setIdCursoEstudiante(Long idCursoEstudiante) {
        this.idCursoEstudiante = idCursoEstudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
