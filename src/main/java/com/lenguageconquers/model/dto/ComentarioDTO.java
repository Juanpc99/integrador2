package com.lenguageconquers.model.dto;

import java.io.Serializable;

public class ComentarioDTO implements Serializable {

    private static final long serialVersionUID = 745554423196286428L;

    private Long idComentario;
    private String comentarios;
    private Long idRetoEstudiante;

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Long getIdRetoEstudiante() {
        return idRetoEstudiante;
    }

    public void setIdRetoEstudiante(Long idRetoEstudiante) {
        this.idRetoEstudiante = idRetoEstudiante;
    }

}
