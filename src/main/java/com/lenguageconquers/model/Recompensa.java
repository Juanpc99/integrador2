package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recompensa")
@Getter
@Setter
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recompensa")
    private Long idRecompensa;

    @Column(name = "titulo_recompensa")
    private String tituloRecompensa;

    @Column(name = "img_recompensa")
    private String imgRecompensa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recompensa")
    private List<Mision> misiones = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recompensa")
    private List<RecompensaEstudiante> recompensaEstudiantes = new ArrayList<>();
}
