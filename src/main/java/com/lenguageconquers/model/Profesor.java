package com.lenguageconquers.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "profesor")

public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long id;

    @Column(name = "nombre_profesor")
    private String nombreProfesor;

    @Column(name = "apellido_profesor")
    private String apellidoProfesor;

    @Column(name = "correo_profesor")
    private String correoProfesor;

    @Column(name = "cumpleaños_profesor")
    private Date cumpleAñosProfesor;

    private boolean confirmado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")
    List<Curso> cursos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")
    List<Archivo> archivos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public String getCorreoProfesor() {
        return correoProfesor;
    }

    public void setCorreoProfesor(String correoProfesor) {
        this.correoProfesor = correoProfesor;
    }

    public Date getCumpleAñosProfesor() {
        return cumpleAñosProfesor;
    }

    public void setCumpleAñosProfesor(Date cumpleAñosProfesor) {
        this.cumpleAñosProfesor = cumpleAñosProfesor;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
