package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Avatar;
import com.lenguageconquers.model.Programa;
import com.lenguageconquers.model.Semestre;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

public class EstudianteDTO implements Serializable {


    private static final long serialVersionUID = 8145639634901780513L;

    private Long idEstudiante;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String nicknameEstudiante;
    private int puntajeEstudiante;
    private String correoEstudiante;
    private Date fechaNacimiento;
    private boolean confirmado;
    private String codigoConfirmado;
    private String passwordEstudiante;
    private Date fechaRegistro;

    private Long idAvatar;
    private Long idGenero;
    private Long idSemestre;
    private Long idEstado;
    private Long idPrograma;
}
