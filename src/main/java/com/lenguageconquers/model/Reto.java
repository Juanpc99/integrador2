package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Reto")
@Getter
@Setter
public class Reto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reto")
    private Long idReto;

    @Column(name = "fecha_limite")
    private Date fechaLimite;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "descripcion_reto")
    private String descripcionReto;

    @Column(name = "titulo_reto")
    private String tituloReto;

    @Column(name = "maximo_intentos")
    private Long maximoIntentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mision")
    private Mision mision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reto")
    private List<RetoEstudiante> retoEstudiantes = new ArrayList<>();
}
