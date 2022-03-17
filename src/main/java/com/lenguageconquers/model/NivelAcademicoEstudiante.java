package com.lenguageconquers.model;

import javax.persistence.*;

@Entity
@Table(name = "nivel_academico_estudiante")
public class NivelAcademicoEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_acad_estudiante")
    private Long idNivelAcadEstudiante;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel_academico", nullable = false)
    private NivelAcademico nivelAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
}
