package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_mision")
@Getter
@Setter
public class TipoMision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_mision")
    private Long idTipoMision;

    @Column(name = "descripcion_tipo")
    private String descripcionTipo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoMision")
    private List<Mision> misiones = new ArrayList<>();
}
