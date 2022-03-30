package com.lenguageconquers.model;

import javax.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long idComentario;

    @Column(name = "comentarios")
    private String comentarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reto_estudiante")
    private RetoEstudiante retoEstudiante;

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

    public RetoEstudiante getRetoEstudiante() {
        return retoEstudiante;
    }

    public void setRetoEstudiante(RetoEstudiante retoEstudiante) {
        this.retoEstudiante = retoEstudiante;
    }
}
