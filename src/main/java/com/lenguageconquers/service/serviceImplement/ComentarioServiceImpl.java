package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.ComentarioDAO;
import com.lenguageconquers.dao.RetoEstudianteDAO;
import com.lenguageconquers.model.Comentario;
import com.lenguageconquers.model.dto.ComentarioDTO;
import com.lenguageconquers.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioDAO comentarioDAO;

    @Autowired
    private RetoEstudianteDAO retoEstudianteDAO;

    @Override
    public String crearComentarios(ComentarioDTO comentarioDTO) {
        try {

            Comentario comentario = new Comentario();
            if(comentarioDTO.getIdRetoEstudiante() == null){
                throw new Exception("Se debe ingresar el id de un reto estudiente para asignar el comentario");
            }
            if(retoEstudianteDAO.findById(comentarioDTO.getIdRetoEstudiante()).toString().equals("Optional.empty")){
                throw new Exception("No se encuentra el id de reto estudiante, indroduzca uno valido");
            }
            if(comentarioDTO.getComentarios() == null){
                throw new Exception("Se debe ingresar un comentario");
            }
            if(comentarioDTO.getComentarios().length()>500){
                throw new Exception("El comentario es muy largo");
            }
            comentario.setComentarios(comentarioDTO.getComentarios());
            comentario.setRetoEstudiante(retoEstudianteDAO.findById(comentarioDTO.getIdRetoEstudiante()).get());
            comentarioDAO.save(comentario);
            return "Se creo exitosamente el comentario";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Comentario> listar() {
        return comentarioDAO.findAll();
    }
}
