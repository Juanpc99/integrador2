package com.lenguageconquers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    private List<RolEstudiante> roles = new ArrayList<>();
}
