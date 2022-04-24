package com.lenguageconquers.model;

import javax.persistence.*;

@Entity
@Table(name = "roles_reto")
public class RolReto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_reto")
    private Long idRolReto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reto")
    private Reto reto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private Rol rol;



    public Long getIdRolReto() {
        return idRolReto;
    }

    public void setIdRolReto(Long idRolReto) {
        this.idRolReto = idRolReto;
    }

    public Reto getReto() {
        return this.reto;
    }

    public void setReto(Reto reto) {
        this.reto = reto;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
