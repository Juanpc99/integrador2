package com.lenguageconquers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "recursos")
public class Recursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recurso")
    private Long idRecurso;

    @Column(name = "archivo")
    private String archivo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "descargas")
    private int descargas;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recurso")
    private List<RecursoEstudiante> recursosEstudiantes = new ArrayList<>();
}
