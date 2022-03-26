package com.lenguageconquers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "programa")
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programa")
    private Long idPrograma;

    @Column(name = "nombre_programa")
    private String nombrePrograma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "programa")
    private List<Curso> cursos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "programa")
    private List<Estudiante> estudiantePrograma = new ArrayList<>();

    public Long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Estudiante> getEstudiantePrograma() {
        return estudiantePrograma;
    }

    public void setEstudiantePrograma(List<Estudiante> estudiantePrograma) {
        this.estudiantePrograma = estudiantePrograma;
    }
}
