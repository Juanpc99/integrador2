package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.*;
import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.dto.CursoDTO;
import com.lenguageconquers.model.dto.EstudianteDTO;
import com.lenguageconquers.model.dto.RetoDTO;
import com.lenguageconquers.service.EstudianteService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Scope("singleton")
@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteDAO estudianteDAO;

    @Autowired
    private SemestreDAO semestreDAO;

    @Autowired
    private GeneroDAO generoDAO;

    @Autowired
    private AvatarDAO avatarDAO;

    @Autowired
    private EstadoDAO estadoDAO;

    @Autowired
    private ProgramaDAO programaDAO;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public String crearEstudiante(EstudianteDTO estudianteDTO) throws Exception {

        Estudiante estudiante = new Estudiante();
        if(estudianteDTO.getIdAvatar() == null){
            throw new Exception("Debe ingresar un id avatar");
        }
        if(estudianteDTO.getIdGenero() == null){
            throw new Exception("Debe ingresar un id genero");
        }
        if(estudianteDTO.getIdSemestre() == null){
            throw new Exception("Debe ingresar un id semestre");
        }
        if(estudianteDTO.getIdPrograma() == null){
            throw new Exception("Debe ingresar un id programa");
        }
        if(estudianteDTO.getIdEstado() == null){
            throw new Exception("Debe ingresar un id estado");
        }
        if(estudianteDTO.getIdAvatar()<0){
            throw new Exception("Debe ingresar un id avatar mayor a 0");
        }
        if(estudianteDTO.getIdPrograma()<0){
            throw new Exception("Debe ingresar un id programa mayor a 0");
        }
        if(estudianteDTO.getIdEstado()<0){
            throw new Exception("Debe ingresar un id estado mayor a 0");
        }
        if(estudianteDTO.getIdSemestre()<0){
            throw new Exception("Debe ingresar un id semestre mayor a 0");
        }
        if(estudianteDTO.getIdGenero()<0){
            throw new Exception("Debe ingresar un id genero mayor a 0");
        }
        if(avatarDAO.findById(estudianteDTO.getIdAvatar()).toString().equals("Optional.empty")){
            throw new Exception("Debe ingresar un id avatar que exista");
        }
        if(generoDAO.findById(estudianteDTO.getIdGenero()).toString().equals("Optional.empty")){
            throw new Exception("Debe ingresar un id genero que exista");
        }
        if(semestreDAO.findById(estudianteDTO.getIdSemestre()).toString().equals("Optional.empty")){
            throw new Exception("Debe ingresar un id semestre que exista");
        }
        if(estadoDAO.findById(estudianteDTO.getIdEstado()).toString().equals("Optional.empty")){
            throw new Exception("Debe ingresar un id estado que exista");
        }
        if(programaDAO.findById(estudianteDTO.getIdPrograma()).toString().equals("Optional.empty")){
            throw new Exception("Debe ingresar un id programa que exista");
        }
        if(estudianteDTO.getNombreEstudiante() == null || estudianteDTO.getNombreEstudiante().trim().equals("")){
            throw new Exception("Debe ingresar el nombre del estudiante");
        }
        if(estudianteDTO.getNombreEstudiante().length()>80){
                throw new Exception("El nombre del estudiante es muy largo");
        }
        if(estudianteDTO.getApellidoEstudiante() == null || estudianteDTO.getApellidoEstudiante().trim().equals("")){
            throw new Exception("Debe ingresar el apellido del estudiante");
        }
        if(estudianteDTO.getApellidoEstudiante().length()>80){
            throw new Exception("El apellido del estudiante es muy largo");
        }
        if(estudianteDTO.getNicknameEstudiante() == null || estudianteDTO.getNicknameEstudiante().trim().equals("")){
            throw new Exception("Debe ingresar un nick name para el estudiante");
        }
        if(estudianteDTO.getNicknameEstudiante().length()>80){
            throw new Exception("Debe ingresar un nick name para el estudiante");
        }
        if(estudianteDTO.getPuntajeEstudiante()<0){
            throw new Exception("El puntaje no debe ser negativo");
        }
        if(estudianteDTO.getCorreoEstudiante() == null || estudianteDTO.getCorreoEstudiante().trim().equals("")){
            throw new Exception("Debe ingresar un correo del estudiante");
        }
        if(!Validaciones.formatoCorreoValido(estudianteDTO.getCorreoEstudiante())){
            throw new Exception("Debe ingresar un correo valido");
        }
        if(estudianteDTO.getFechaNacimiento() == null){
            throw new Exception("Debe ingresar una fecha de nacimiento");
        }
        Date fecha = new Date();
        if(estudianteDTO.getFechaNacimiento().compareTo(fecha)>0){
            throw new Exception("Digite una fecha de nacimiento valida");
        }
        if(estudianteDTO.getCodigoConfirmado() == null || estudianteDTO.getCodigoConfirmado().trim().equals("")){
            throw new Exception("Debe ingresar un codigo confirmado");
        }
        if(estudianteDTO.getPasswordEstudiante() == null || estudianteDTO.getPasswordEstudiante().trim().equals("")){
            throw new Exception("Debe ingresar una comtraseña");
        }
        if(estudianteDTO.getFechaRegistro() == null){
            throw new Exception("Debe ingresar una fecha de registro");
        }
        estudiante.setNombreEstudiante(estudianteDTO.getNombreEstudiante());
        estudiante.setApellidoEstudiante(estudianteDTO.getApellidoEstudiante());
        estudiante.setNicknameEstudiante(estudianteDTO.getNicknameEstudiante());
        estudiante.setPuntajeEstudiante(estudianteDTO.getPuntajeEstudiante());
        estudiante.setPasswordEstudiante(encoder.encode(estudianteDTO.getPasswordEstudiante()));
        estudiante.setCorreoEstudiante(estudianteDTO.getCorreoEstudiante());
        estudiante.setCodigoConfirmado(estudianteDTO.getCodigoConfirmado());
        estudiante.setSemestre(semestreDAO.findById(estudianteDTO.getIdSemestre()).get());
        estudiante.setGenero(generoDAO.findById(estudianteDTO.getIdGenero()).get());
        estudiante.setFechaRegistro(estudianteDTO.getFechaRegistro());
        estudiante.setConfirmado(estudiante.isConfirmado());
        estudiante.setAvatar(avatarDAO.findById(estudianteDTO.getIdAvatar()).get());
        estudiante.setEstado(estadoDAO.findById(estudianteDTO.getIdEstado()).get());
        estudiante.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
        estudiante.setPrograma(programaDAO.findById(estudianteDTO.getIdPrograma()).get());
        estudianteDAO.save(estudiante);
        return "Se creo exitosamente al estudiante";
    }

    @Override
    public List<EstudianteDTO> listaEstudiantes() {
        List<EstudianteDTO> estudianteDTOS = mapeoForEstudiante(estudianteDAO.findAll());
        return estudianteDTOS;
    }

    @Override
    public List<EstudianteDTO> listaPorAvatares(Long idAvatar) throws Exception {
        List<Estudiante> estudianteList = estudianteDAO.findByIdAvatar(idAvatar);
        List<EstudianteDTO>  estudianteDTOS = new ArrayList<>();
        for(Estudiante  estudiante: estudianteList){
            EstudianteDTO estudianteDTO = new EstudianteDTO();
            estudianteDTO.setIdEstudiante(estudiante.getIdEstudiante());
            estudianteDTO.setNombreEstudiante(estudiante.getNombreEstudiante());
            estudianteDTO.setApellidoEstudiante(estudiante.getApellidoEstudiante());
            estudianteDTO.setNicknameEstudiante(estudiante.getNicknameEstudiante());
            estudianteDTO.setPuntajeEstudiante(estudiante.getPuntajeEstudiante());
            estudianteDTO.setPasswordEstudiante(encoder.encode(estudianteDTO.getPasswordEstudiante()));
            estudianteDTO.setCorreoEstudiante(estudiante.getCorreoEstudiante());
            estudianteDTO.setCodigoConfirmado(estudiante.getCodigoConfirmado());
            estudianteDTO.setIdSemestre(estudiante.getSemestre().getIdSemestre());
            estudianteDTO.setIdGenero(estudiante.getGenero().getIdGenero());
            estudianteDTO.setFechaRegistro(estudiante.getFechaRegistro());
            estudianteDTO.setConfirmado(estudiante.isConfirmado());
            estudianteDTO.setIdAvatar(estudiante.getAvatar().getIdAvatar());
            estudianteDTO.setIdEstado(estudiante.getEstado().getIdEstado());
            estudianteDTO.setFechaNacimiento(estudiante.getFechaNacimiento());
            estudianteDTO.setIdPrograma(estudiante.getPrograma().getIdPrograma());
            estudianteDTOS.add(estudianteDTO);
        }
        return estudianteDTOS;
    }

    public EstudianteDTO mapeo(Estudiante estudiante){
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setIdEstudiante(estudiante.getIdEstudiante());
        estudianteDTO.setNombreEstudiante(estudiante.getNombreEstudiante());
        estudianteDTO.setApellidoEstudiante(estudiante.getApellidoEstudiante());
        estudianteDTO.setNicknameEstudiante(estudiante.getNicknameEstudiante());
        estudianteDTO.setPuntajeEstudiante(estudiante.getPuntajeEstudiante());
        estudianteDTO.setPasswordEstudiante(encoder.encode(estudiante.getPasswordEstudiante()));
        estudianteDTO.setCorreoEstudiante(estudiante.getCorreoEstudiante());
        estudianteDTO.setCodigoConfirmado(estudiante.getCodigoConfirmado());
        estudianteDTO.setIdSemestre(estudiante.getSemestre().getIdSemestre());
        estudianteDTO.setIdGenero(estudiante.getGenero().getIdGenero());
        estudianteDTO.setFechaRegistro(estudiante.getFechaRegistro());
        estudianteDTO.setConfirmado(estudiante.isConfirmado());
        estudianteDTO.setIdAvatar(estudiante.getAvatar().getIdAvatar());
        estudianteDTO.setIdEstado(estudiante.getEstado().getIdEstado());
        estudianteDTO.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteDTO.setIdPrograma(estudiante.getPrograma().getIdPrograma());

        return estudianteDTO;
    }
    public List<EstudianteDTO> mapeoForEstudiante (List<Estudiante> estudiantes) {
        List<EstudianteDTO> estudianteDTOS = new ArrayList<>();
        for (Estudiante estudiante: estudiantes) {
            EstudianteDTO estudianteDTO = mapeo(estudiante);
            estudianteDTOS.add(estudianteDTO);
        }
        return estudianteDTOS;
    }


}
