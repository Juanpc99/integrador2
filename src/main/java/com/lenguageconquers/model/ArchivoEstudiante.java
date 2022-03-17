package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "archivo_estudiante")
@Getter
@Setter
public class ArchivoEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_archivo_estudiante")
    private Long idArchivoestudiante;

    private String descripcion;

    @Column(name = "fecha_creacion")
    private Date fecaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo", nullable = false)
    private Archivo archivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;
}
