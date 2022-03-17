package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mision_estudiante")
@Getter
@Setter
public class MisionEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mision_estudiante")
    private Long idMisionestudiante;

    @Column(name = "calificacion")
    private Double calificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mision", nullable = false)
    private Mision mision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_notas", nullable = false)
    private Nota nota;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "misionEstudiante")
    private List<RolEstudianteMision> rolEstudianteMisiones = new ArrayList<>();
}
