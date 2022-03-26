package com.lenguageconquers.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estado_tipo")

public class EstadoTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_tipo")
    private Long idEstadoTipo;

    @Column(name = "nombre_estado_tipo")
    private String nombreEstadoTipo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estadoTipo")
    private List<Estado> estados = new ArrayList<>();
}
