package com.lenguageconquers.model.dto;


import java.io.Serializable;

public class MisionDTO implements Serializable {


    private static final long serialVersionUID = -7202595379127891186L;

    private Long idMision;
    private String tituloMision;
    private int puntajeMision;
    private Long idNivelMision;
    private Long idTipoMision;
    private Long idRecompensa;

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

    public Long getIdNivelMision() {
        return idNivelMision;
    }

    public void setIdNivelMision(Long idNivelMision) {
        this.idNivelMision = idNivelMision;
    }

    public Long getIdTipoMision() {
        return idTipoMision;
    }

    public void setIdTipoMision(Long idTipoMision) {
        this.idTipoMision = idTipoMision;
    }

    public Long getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(Long idRecompensa) {
        this.idRecompensa = idRecompensa;
    }
}
