package com.lenguageconquers.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_mision")

public class TipoMision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_mision")
    private Long idTipoMision;

    @Column(name = "descripcion_tipo")
    private String descripcionTipo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoMision")
    private List<Mision> misiones = new ArrayList<>();

    public Long getIdTipoMision() {
        return idTipoMision;
    }

    public void setIdTipoMision(Long idTipoMision) {
        this.idTipoMision = idTipoMision;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
}
