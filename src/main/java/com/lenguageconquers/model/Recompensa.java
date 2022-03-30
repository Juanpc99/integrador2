package com.lenguageconquers.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recompensa")

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

    public Long getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(Long idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getTituloRecompensa() {
        return tituloRecompensa;
    }

    public void setTituloRecompensa(String tituloRecompensa) {
        this.tituloRecompensa = tituloRecompensa;
    }

    public String getImgRecompensa() {
        return imgRecompensa;
    }

    public void setImgRecompensa(String imgRecompensa) {
        this.imgRecompensa = imgRecompensa;
    }
}
