package com.lenguageconquers.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mision")

public class Mision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mision")
    private Long idMision;

    @Column(name = "titulo_mision")
    private String tituloMision;

    @Column(name = "puntaje_mision")
    private Long puntajeMision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel_mision", nullable = false)
    private NivelMision nivelMision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_mision", nullable = false)
    private TipoMision tipoMision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recompensa", nullable = false)
    private Recompensa recompensa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mision")
    private List<Reto> retos = new ArrayList<>();
    //TODO: Hacer tablas y completar relaciones
}
