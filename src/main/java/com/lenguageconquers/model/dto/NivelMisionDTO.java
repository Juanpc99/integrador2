package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class NivelMisionDTO implements Serializable {


    private static final long serialVersionUID = 5587983368762541099L;

    private Long idNivelMision;
    private String nombreNivel;
    private String imgNivel;
    private int puntajeNivel;
    private int minimoPuntaje;

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
