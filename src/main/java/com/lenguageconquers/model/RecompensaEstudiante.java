package com.lenguageconquers.model;



import javax.persistence.*;

@Entity
@Table(name = "recompensa_estudiante")

public class RecompensaEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recompensa_estudiante")
    private Long idRecompensaEstudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recompensa", nullable = false)
    private Recompensa recompensa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    public Long getIdRecompensaEstudiante() {
        return idRecompensaEstudiante;
    }

    public void setIdRecompensaEstudiante(Long idRecompensaEstudiante) {
        this.idRecompensaEstudiante = idRecompensaEstudiante;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
