package com.lenguageconquers.model.dto;


import java.io.Serializable;

public class RecompensaDTO implements Serializable {


    private static final long serialVersionUID = -6358176417811126059L;

    private Long idRecompensa;
    private String tituloRecompensa;
    private String imgRecompensa;

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
