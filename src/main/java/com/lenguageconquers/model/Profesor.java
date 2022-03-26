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

}
