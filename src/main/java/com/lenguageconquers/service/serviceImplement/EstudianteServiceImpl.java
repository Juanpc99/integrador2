package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.EstudianteDAO;
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
