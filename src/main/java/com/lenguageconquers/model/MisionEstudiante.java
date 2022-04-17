package com.lenguageconquers.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mision_estudiante")
public class MisionEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mision_estudiante")
    private Long idMisionestudiante;

    @Column(name = "calificacion")
    private Double calificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nota", nullable = false)
    private Nota nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mision", nullable = false)
    private Mision mision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "misionEstudiante")
    private List<RolEstudianteMision> rolEstudianteMisiones = new ArrayList<>();




    public Long getIdMisionestudiante() {
        return idMisionestudiante;
    }


    public void setIdMisionestudiante(Long idMisionestudiante) {
        this.idMisionestudiante = idMisionestudiante;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Mision getMision() {
        return mision;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
