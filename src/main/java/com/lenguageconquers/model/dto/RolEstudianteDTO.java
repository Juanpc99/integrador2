package com.lenguageconquers.model.dto;

import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.Rol;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class RolEstudianteDTO implements Serializable {


    private static final long serialVersionUID = 8034472676672296241L;

    private Long idRolEstudiante;

    private Long idRol;
    private Long idEstudiante;
}
