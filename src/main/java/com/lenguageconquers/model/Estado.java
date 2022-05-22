package com.lenguageconquers.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estado")

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    private List<MisionEstudiante> misionEstudiantes = new ArrayList<>();

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public EstadoTipo getEstadoTipo() {
        return estadoTipo;
    }

    public void setEstadoTipo(EstadoTipo estadoTipo) {
        this.estadoTipo = estadoTipo;
    }
}
