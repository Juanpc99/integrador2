package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estado")
@Getter
@Setter
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "nombre_estado")
    private String nombreEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tipo", nullable = false)
    private EstadoTipo estadoTipo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    private List<NivelAcademicoEstudiante> nivelAcademicoEstudiantes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    private List<Reto> retos = new ArrayList<>();

    //TODO: Relacion con tabla misione_estudiante


}
