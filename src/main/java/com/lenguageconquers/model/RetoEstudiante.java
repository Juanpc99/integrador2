package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reto_estudiante")
@Getter
@Setter
public class RetoEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reto_estudiante")
    private Long idRetoEstudiante;

    @Column(name = "observacion")
    private String observacion;

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

}
