package com.lenguageconquers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(name = "nombre_curso")
    private String nombreCurso;

    @Column(name="inicio_curso")
    private Date inicioCurso;

    @Column(name = "fin_curso")
    private Date finCurso;

    @Column(name = "cantidad_estudiantes")
    private int cantidadEstudiantes;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_programa", nullable = false)
    private Curso programa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Curso estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor", nullable = false)
    private Curso profesor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
    private List<Archivo> archivos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
    private List<Reto> retos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
    private List<CursoEstudiante> cursoEstudiantes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
    private List<NivelAcademico> nivelAcademico = new ArrayList<>();

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

    public Curso getPrograma() {
        return programa;
    }

    public void setPrograma(Curso programa) {
        this.programa = programa;
    }

    public Curso getEstado() {
        return estado;
    }

    public void setEstado(Curso estado) {
        this.estado = estado;
    }

    public Curso getProfesor() {
        return profesor;
    }

    public void setProfesor(Curso profesor) {
        this.profesor = profesor;
    }
}
