package com.lenguageconquers.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//@Getter
//@Setter
public class AvatarDTO implements Serializable {


    private static final long serialVersionUID = 2728416259175503133L;

    private Long idAvatar;
    private String imgAvatar;
    private String nombreAvatar;

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
