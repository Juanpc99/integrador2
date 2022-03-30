package com.lenguageconquers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reto_estudiante")

public class RetoEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reto_estudiante")
    private Long idRetoEstudiante;

    @Column(name = "nombre_archivo")
    private String nombreArchivo;

    @Column(name = "url_archivo")
    private String urlArchivo;

    @Column(name = "estado_tarea")
    private String estadoTarea;

    @Column(name = "fecha_subida")
    private Date fechaSubida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reto")
    private Reto reto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "retoEstudiante")
    private List<Comentario> comentarios = new ArrayList<>();

    public Long getIdRetoEstudiante() {
        return idRetoEstudiante;
    }

    public void setIdRetoEstudiante(Long idRetoEstudiante) {
        this.idRetoEstudiante = idRetoEstudiante;
    }



    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public Reto getReto() {
        return reto;
    }

    public void setReto(Reto reto) {
        this.reto = reto;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
