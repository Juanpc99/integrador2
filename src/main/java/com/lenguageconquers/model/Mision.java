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
    private int puntajeMision;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mision")
    private List<MisionEstudiante> misionEstudiantes = new ArrayList<>();

    public Long getIdMision() {
        return idMision;
    }

    public void setIdMision(Long idMision) {
        this.idMision = idMision;
    }

    public String getTituloMision() {
        return tituloMision;
    }

    public void setTituloMision(String tituloMision) {
        this.tituloMision = tituloMision;
    }

    public int getPuntajeMision() {
        return puntajeMision;
    }

    public void setPuntajeMision(int puntajeMision) {
        this.puntajeMision = puntajeMision;
    }

    public NivelMision getNivelMision() {
        return nivelMision;
    }

    public void setNivelMision(NivelMision nivelMision) {
        this.nivelMision = nivelMision;
    }

    public TipoMision getTipoMision() {
        return tipoMision;
    }

    public void setTipoMision(TipoMision tipoMision) {
        this.tipoMision = tipoMision;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }

    public List<Reto> getRetos() {
        return retos;
    }

    public void setRetos(List<Reto> retos) {
        this.retos = retos;
    }
}
