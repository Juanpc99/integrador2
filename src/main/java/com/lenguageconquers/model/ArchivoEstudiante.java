package com.lenguageconquers.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "archivo_estudiante")

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

    public Long getIdArchivoestudiante() {
        return idArchivoestudiante;
    }

    public void setIdArchivoestudiante(Long idArchivoestudiante) {
        this.idArchivoestudiante = idArchivoestudiante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecaCreacion() {
        return fecaCreacion;
    }

    public void setFecaCreacion(Date fecaCreacion) {
        this.fecaCreacion = fecaCreacion;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
