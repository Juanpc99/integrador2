package com.lenguageconquers.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AvatarDTO implements Serializable {


    private static final long serialVersionUID = 2728416259175503133L;

    private Long idAvatar;
    private String imgAvatar;
    private String nombreAvatar;
}
