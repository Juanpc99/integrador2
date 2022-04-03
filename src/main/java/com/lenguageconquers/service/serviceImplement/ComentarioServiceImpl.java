package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.ComentarioDAO;
import com.lenguageconquers.dao.RetoEstudianteDAO;
import com.lenguageconquers.model.Comentario;
import com.lenguageconquers.model.dto.ComentarioDTO;
import com.lenguageconquers.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Scope("singleton")
@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioDAO comentarioDAO;

    @Autowired
    private RetoEstudianteDAO retoEstudianteDAO;

    @Override
    public String crearComentarios(ComentarioDTO comentarioDTO) throws Exception {
         Comentario comentario = new Comentario();
         if(comentarioDTO.getIdRetoEstudiante() == null){
                throw new Exception("Se debe ingresar el id de un reto estudiente para asignar el comentario");
         }
         if(retoEstudianteDAO.findById(comentarioDTO.getIdRetoEstudiante()).toString().equals("Optional.empty")){
             throw new Exception("No se encuentra el id de reto estudiante, indroduzca uno valido");
         }
         if(comentarioDTO.getComentarios() == null || comentarioDTO.getComentarios().trim().equals("")){
             throw new Exception("Se debe ingresar un comentario");
         }
         if(comentarioDTO.getComentarios().length()>500){
             throw new Exception("El comentario es muy largo");
         }
         comentario.setComentarios(comentarioDTO.getComentarios());
         comentario.setRetoEstudiante(retoEstudianteDAO.findById(comentarioDTO.getIdRetoEstudiante()).get());
         comentarioDAO.save(comentario);
         return "Se creo exitosamente el comentario";
    }

    @Override
    public List<Comentario> listar() {
        return comentarioDAO.findAll();
    }

    @Override
    public List<Comentario> listarPorIdRetoEstudiante(Long idEstudiante, Long idReto) throws Exception {
        List<Comentario> comentarioList = comentarioDAO.findByIdRetoEstudiante(idEstudiante, idReto);
        List<ComentarioDTO> comentariosDtos = new ArrayList<>();
        for (Comentario comentario: comentarioList) {
            ComentarioDTO comentarioDTO = new ComentarioDTO();
            comentarioDTO.setIdComentario(comentario.getIdComentario());
            comentarioDTO.setIdReto(comentario.getRetoEstudiante().getReto().getIdReto());
            comentarioDTO.setComentarios(comentario.getComentarios());
            comentarioDTO.setIdRetoEstudiante(comentario.getRetoEstudiante().getIdRetoEstudiante());
            comentarioDTO.setIdEstudiante(comentario.getRetoEstudiante().getEstudiante().getIdEstudiante());
            comentarioDTO.setIdProfesor(comentario.getRetoEstudiante().getReto().getCurso().getProfesor().getId());
            comentariosDtos.add(comentarioDTO);
        }
        return comentarioList;
    }
    /*
    @Override
    public List<Comentario> listarPorIdRetoEstudiante(Long idRetoEstudiante)  throws Exception{
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        if(idRetoEstudiante == null){
            throw new Exception("debe ingresar el id del reto estudiante");
        }
        if(idRetoEstudiante <=0){
            throw new Exception("El id del reto estudiante no debe ser menor o igual a 0");
        }
        List<Comentario> comentarios = (List<Comentario>) comentarioDAO.findById(comentarioDTO.getIdRetoEstudiante()).get();
        if(comentarios.isEmpty()){
            throw new Exception("No se encontraron comentarios asociados a ese id de reto estudiante");
        }
        return comentarios;
    }

    @Override
    public List<Comentario> comentariosEstudianteProfesor(Long idRetoEstudiante) throws Exception {
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        if(idRetoEstudiante == null){
            throw new Exception("debe ingresar el id del reto estudiante");
        }
        if(idRetoEstudiante <=0){
            throw new Exception("El id del reto estudiante no debe ser menor o igual a 0");
        }
        List<Comentario> comentarios = comentarioDAO.comentariosEstudianteProfesor(comentarioDTO.getIdRetoEstudiante());
        if(comentarios.isEmpty()){
            throw new Exception("No se encontraron comentarios asociados a ese id de reto estudiante");
        }
        return comentarios;

    }

     */
}
