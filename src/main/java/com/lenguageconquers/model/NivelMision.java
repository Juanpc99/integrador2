package com.lenguageconquers.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nivel_mision")

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
    private int puntajeNivel;

    @Column(name = "minimo_puntaje")
    private int minimoPuntaje;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nivelMision")
    private List<Mision> misiones = new ArrayList<>();

    public Long getIdNivelMision() {
        return idNivelMision;
    }

    public void setIdNivelMision(Long idNivelMision) {
        this.idNivelMision = idNivelMision;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

    public String getImgNivel() {
        return imgNivel;
    }

    public void setImgNivel(String imgNivel) {
        this.imgNivel = imgNivel;
    }

    public int getPuntajeNivel() {
        return puntajeNivel;
    }

    public void setPuntajeNivel(int puntajeNivel) {
        this.puntajeNivel = puntajeNivel;
    }

    public int getMinimoPuntaje() {
        return minimoPuntaje;
    }

    public void setMinimoPuntaje(int minimoPuntaje) {
        this.minimoPuntaje = minimoPuntaje;
    }
}
