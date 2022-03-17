package com.lenguageconquers.model;

import javax.persistence.*;

@Entity
@Table(name = "recurso_estudiante")
public class RecursoEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recurso_estudiante")
    private Long idRecursoEstudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recurso", nullable = false)
    private Recursos recurso;
}
