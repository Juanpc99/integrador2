package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genero")
@Getter
@Setter
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genro")
    private Long idGenero;

    @Column(name = "nombre_genero")
    private String nombreGenero;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genero")
    public List<Profesor> profesores = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genero")
    public List<Estudiante> estudiantes = new ArrayList<>();
}
