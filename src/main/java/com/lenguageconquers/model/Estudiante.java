package com.lenguageconquers.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(name = "nombre_estudiante")
    private String nombreEstudiante;

    @Column(name = "apellido_estudiante")
    private String apellidoEstudiante;

    @Column(name = "nickname_estudiante")
    private String nicknameEstudiante;

    @Column(name = "puntajeEstudiante")
    private int puntajeEstudiante;

    @Column(name = "correo_estudiante")
    private String correoEstudiante;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="confirmado")
    private boolean confirmado;

    // verificar tipo
    @Column(name = "codigo_confirmado")
    private String codigoConfirmado;

    @Column(name = "password_estudiante")
    private String passwordEstudiante;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_avatar", nullable = false)
    private Avatar avatar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_semestre", nullable = false)
    private Semestre semestre;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
   */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    List<ArchivoEstudiante> archivoEstudiantes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    private List<RetoEstudiante> retoEstudiantes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    private List<RolEstudiante> estudiantesRol = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    private List<RecursoEstudiante> recursos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    private List<Bitacora> bitacora = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    private List<CursoEstudiante> cursos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    private List<NivelAcademicoEstudiante> nivelAcademicoEstudiantes = new ArrayList<>();


    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public String getNicknameEstudiante() {
        return nicknameEstudiante;
    }

    public void setNicknameEstudiante(String nicknameEstudiante) {
        this.nicknameEstudiante = nicknameEstudiante;
    }

    public int getPuntajeEstudiante() {
        return puntajeEstudiante;
    }

    public void setPuntajeEstudiante(int puntajeEstudiante) {
        this.puntajeEstudiante = puntajeEstudiante;
    }

    public String getCorreoEstudiante() {
        return correoEstudiante;
    }

    public void setCorreoEstudiante(String correoEstudiante) {
        this.correoEstudiante = correoEstudiante;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public String getCodigoConfirmado() {
        return codigoConfirmado;
    }

    public void setCodigoConfirmado(String codigoConfirmado) {
        this.codigoConfirmado = codigoConfirmado;
    }

    public String getPasswordEstudiante() {
        return passwordEstudiante;
    }

    public void setPasswordEstudiante(String passwordEstudiante) {
        this.passwordEstudiante = passwordEstudiante;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }
}
