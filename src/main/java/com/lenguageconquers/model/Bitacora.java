package com.lenguageconquers.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Bitacoras")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bitacora")
    private Long idBitacora;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_estudiante", nullable = false)
    private Estudiante estudiante;

}
