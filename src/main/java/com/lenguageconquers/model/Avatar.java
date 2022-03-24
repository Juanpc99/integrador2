package com.lenguageconquers.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Avatar")
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_avatar")
    private Long idAvatar;

    @Column(name = "img_avatar")
    private String imgAvatar;

    @Column(name = "nombre_avatar")
    private String nombreAvatar;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "avatar")
    private List<Estudiante> estudianteAvatar = new ArrayList<>();


    public Long getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(Long idAvatar) {
        this.idAvatar = idAvatar;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getNombreAvatar() {
        return nombreAvatar;
    }

    public void setNombreAvatar(String nombreAvatar) {
        this.nombreAvatar = nombreAvatar;
    }

}
