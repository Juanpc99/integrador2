package com.lenguageconquers.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Avatar")
@Getter
@Setter
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
}
