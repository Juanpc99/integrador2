package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.*;
import com.lenguageconquers.model.Estudiante;
import com.lenguageconquers.model.dto.EstudianteDTO;
import com.lenguageconquers.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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

    @Override
    public String crearEstudiante(EstudianteDTO estudianteDTO) {
        try{
            Estudiante estudiante = new Estudiante();
            estudiante.setNombreEstudiante(estudianteDTO.getNombreEstudiante());
            estudiante.setApellidoEstudiante(estudianteDTO.getApellidoEstudiante());
            estudiante.setNicknameEstudiante(estudianteDTO.getNicknameEstudiante());
            estudiante.setPuntajeEstudiante(estudianteDTO.getPuntajeEstudiante());
            estudiante.setPasswordEstudiante(estudianteDTO.getPasswordEstudiante());
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
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Estudiante> listaEstudiantes() {
        return estudianteDAO.findAll();
    }

    /*
    @Override
    public EstudianteDTO findByIdEstudiante(Long idEstudiante) {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        Estudiante estudiante = estudianteDAO.findById(idEstudiante).get();
        estudianteDTO.setIdEstudiante(estudiante.getIdEstudiante());
        estudianteDTO.setPuntajeEstudiante(estudiante.getPuntajeEstudiante());
        estudianteDTO.setPasswordEstudiante(estudiante.getPasswordEstudiante());
        estudianteDTO.setNicknameEstudiante(estudiante.getNicknameEstudiante());
        estudianteDTO.setNombreEstudiante(estudiante.getNombreEstudiante());
        estudianteDTO.setApellidoEstudiante(estudiante.getApellidoEstudiante());
        estudianteDTO.setCodigoConfirmado(estudiante.getCodigoConfirmado());
        estudianteDTO.setConfirmado(estudiante.isConfirmado());
        estudianteDTO.setIdAvatar(estudiante.getAvatar().getIdAvatar());
        estudianteDTO.setIdEstado(estudiante.getEstado().getIdEstado());
        estudianteDTO.setIdPrograma(estudiante.getPrograma().getIdPrograma());
        estudianteDTO.setIdSemestre(estudiante.getSemestre().getIdSemestre());
        estudianteDTO.setIdGenero(estudiante.getGenero().getIdGenero());
        estudianteDTO.setCorreoEstudiante(estudiante.getCorreoEstudiante());
        estudianteDTO.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteDTO.setFechaRegistro(estudiante.getFechaRegistro());
        return estudianteDTO;
    }
*/

/**
    @Override
    public Estudiante registrar(Estudiante estudiante) {
        return estudianteDAO.save(estudiante);
    }

    @Override
    public Estudiante modificar(Estudiante estudiante) {
        return estudianteDAO.save(estudiante);
    }

    @Override
    public void eliminar(int id) {
       // estudianteDAO.delete(id);
    }

    @Override
    public Estudiante listarId(int id) {
        return null;
        //return estudianteDAO.findOne(id);
    }

    @Override
    public List<Estudiante> listar() {
        return estudianteDAO.findAll();
    }

    @Override
    public Estudiante buscar(String nombreEstudiante) {
        return estudianteDAO.findOneByNombreEstudiante(nombreEstudiante);
    }
    */
}
