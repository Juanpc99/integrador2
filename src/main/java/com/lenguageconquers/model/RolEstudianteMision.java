package com.lenguageconquers.model;


import javax.persistence.*;

@Entity
@Table(name = "rol_estudiante_mision")

public class RolEstudianteMision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_estudiante_mis")
    private Long idRolEstudianteMis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mision_estudiante", nullable = false)
    private MisionEstudiante misionEstudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_estudiante", nullable = false)
    private RolEstudiante rolEstudiante;

}
