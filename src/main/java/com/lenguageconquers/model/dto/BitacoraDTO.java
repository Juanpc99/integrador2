package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Estudiante;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class BitacoraDTO implements Serializable {


    private static final long serialVersionUID = -5203171069181774767L;

    private Long idBitacora;
    private Date fechaIngreso;
    private Date fechaSalida;
    private Long idEstudiante;


}
