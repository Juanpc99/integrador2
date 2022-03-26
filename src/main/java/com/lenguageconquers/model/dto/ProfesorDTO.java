package com.lenguageconquers.model.dto;


import java.io.Serializable;
import java.util.Date;

public class ProfesorDTO implements Serializable {


    private static final long serialVersionUID = 5331565474060221351L;

    private Long id;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String correoProfesor;
    private Date cumpleAñosProfesor;
    private boolean confirmado;
}
