package com.lenguageconquers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facultad")
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_facultad")
    private Long idFacultad;

    @Column(name = "nombre_facultad")
    private String nombreFacultad;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "facultad")
    private List<Facultad> facultad = new ArrayList<>();
}
