package com.lenguageconquers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    private List<RolEstudiante> roles = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    private List<RolReto> rolesReto = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    private List<RetoEstudiante> retoEstudiantes = new ArrayList<>();

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<RolEstudiante> getRoles() {
        return roles;
    }

    public void setRoles(List<RolEstudiante> roles) {
        this.roles = roles;
    }
}
