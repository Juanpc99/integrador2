package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class GruposDTO implements Serializable {


    private static final long serialVersionUID = -4403771593406255052L;

    private Long idGrupo;
    private String nombreGrupo;


    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }


}
