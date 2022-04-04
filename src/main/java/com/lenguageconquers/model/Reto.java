package com.lenguageconquers.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Reto")
public class Reto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reto")
    private Long idReto;

    @Column(name = "fecha_limite")
    private Date fechaLimite;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "descripcion_reto")
    private String descripcionReto;

    @Column(name = "titulo_reto")
    private String tituloReto;

    @Column(name = "maximo_intentos")
    private int maximoIntentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mision")
    private Mision mision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reto")
    private List<RetoEstudiante> retoEstudiantes = new ArrayList<>();

    public Long getIdReto() {
        return idReto;
    }

    public void setIdReto(Long idReto) {
        this.idReto = idReto;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDescripcionReto() {
        return descripcionReto;
    }

    public void setDescripcionReto(String descripcionReto) {
        this.descripcionReto = descripcionReto;
    }

    public String getTituloReto() {
        return tituloReto;
    }

    public void setTituloReto(String tituloReto) {
        this.tituloReto = tituloReto;
    }

    public int getMaximoIntentos() {
        return maximoIntentos;
    }

    public void setMaximoIntentos(int maximoIntentos) {
        this.maximoIntentos = maximoIntentos;
    }

    public Mision getMision() {
        return mision;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<RetoEstudiante> getRetoEstudiantes() {
        return retoEstudiantes;
    }

    public void setRetoEstudiantes(List<RetoEstudiante> retoEstudiantes) {
        this.retoEstudiantes = retoEstudiantes;
    }
}
