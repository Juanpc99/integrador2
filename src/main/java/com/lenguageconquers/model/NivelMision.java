package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nivel_mision")
@Getter
@Setter
public class NivelMision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_mision")
    private Long idNivelMision;

    @Column(name = "nombre_nivel")
    private String nombreNivel;

    @Column(name = "img_nivel")
    private String imgNivel;

    @Column(name = "puntaje_nivel")
    private Long puntajeNivel;

    @Column(name = "minimo_puntaje")
    private Long minimoPuntaje;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nivelMision")
    private List<Mision> misiones = new ArrayList<>();

}
