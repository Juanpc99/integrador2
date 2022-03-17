package com.lenguageconquers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nivel_academico")
public class NivelAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_academico")
    private Long idNivelAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nivelAcademico")
    private List<NivelAcademico> nivelAcademico = new ArrayList<>();
}
