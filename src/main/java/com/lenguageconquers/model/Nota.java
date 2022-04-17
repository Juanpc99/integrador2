package com.lenguageconquers.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "nota")

public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idNota;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nota")
    private List<MisionEstudiante> misionEstudiantes = new ArrayList<>();

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

}
