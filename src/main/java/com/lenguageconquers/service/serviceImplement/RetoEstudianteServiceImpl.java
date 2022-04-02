package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.EstudianteDAO;
import com.lenguageconquers.dao.RetoEstudianteDAO;
import com.lenguageconquers.dao.RetosDAO;
import com.lenguageconquers.model.RetoEstudiante;
import com.lenguageconquers.model.dto.RetoEstudianteDTO;
import com.lenguageconquers.service.RetoEstudianteService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Scope("singleton")
@Service
public class RetoEstudianteServiceImpl implements RetoEstudianteService {

    @Autowired
    private RetoEstudianteDAO retoEstudianteDAO;

    @Autowired
    private EstudianteDAO estudianteDAO;

    @Autowired
    private RetosDAO retosDAO;

    //TODO: ESTA MANDANDO ERROR EN NOMBRE_ARCHIVO
    @Override
    public String crearRetoEstudiante(RetoEstudianteDTO retoEstudianteDTO) {
        try {
            RetoEstudiante retoEstudiante = new RetoEstudiante();
            if(estudianteDAO.findById(retoEstudianteDTO.getIdEstudiante()).toString().equals("Optional.empty")){
                throw new Exception("No se encontro el id del estudiante, ingrese uno valido");
            }
            if(retosDAO.findById(retoEstudianteDTO.getIdReto()).toString().equals("Optional.empty")){
                throw new Exception("No se encontro el id del reto, ingrese uno valido");
            }
            if(retoEstudianteDTO.getNombreArchivo() == null){
                throw new Exception("Se debe ingresar un nombre para el archivo");
            }
            if(retoEstudianteDTO.getNombreArchivo().length()>200){
                throw new Exception("El nombre del archivo es muy largo");
            }
            if(retoEstudianteDTO.getUrlArchivo() == null){
                throw new Exception("Se debe ingresar una url para el archivo");
            }
            if(!Validaciones.urlValidator(retoEstudianteDTO.getUrlArchivo())){
                throw new Exception("Se debe ingresar una url valida");
            }
            if(retoEstudianteDTO.getNombreArchivo().length()>200){
                throw new Exception("la url del archivo es muy largo");
            }
            if(retoEstudianteDTO.getEstadoTarea() == null){
                throw new Exception("Se debe ingresar un estado de tarea");
            }
            if(retoEstudianteDTO.getEstadoTarea().length()>50){
                throw new Exception("El estado de la tarea es muy largo");
            }
            if(retoEstudianteDTO.getFechaSubida() == null){
                throw new Exception("Se debe ingresar la fecha ");
            }
            if(retoEstudianteDTO.getFechaSubida().compareTo(new Date())>0){
                throw new Exception("La fecha no debe haber pasado");
            }
            retoEstudiante.setEstudiante(estudianteDAO.findById(retoEstudianteDTO.getIdEstudiante()).get());
            retoEstudiante.setReto(retosDAO.findById(retoEstudianteDTO.getIdReto()).get());
            retoEstudiante.setNombreArchivo(retoEstudianteDTO.getNombreArchivo());
            retoEstudiante.setUrlArchivo(retoEstudianteDTO.getUrlArchivo());
            retoEstudiante.setEstadoTarea(retoEstudianteDTO.getEstadoTarea());
            retoEstudiante.setFechaSubida(retoEstudianteDTO.getFechaSubida());
            retoEstudianteDAO.save(retoEstudiante);
            return "Se creo exitosamente el reto estudiante";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<RetoEstudiante> listar() {
        return retoEstudianteDAO.findAll();
    }
}
