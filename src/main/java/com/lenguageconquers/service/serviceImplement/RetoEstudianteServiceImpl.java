package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.*;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.Mision;
import com.lenguageconquers.model.MisionEstudiante;
import com.lenguageconquers.model.RetoEstudiante;
import com.lenguageconquers.model.dto.RetoEstudianteDTO;
import com.lenguageconquers.service.RetoEstudianteService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Currency;
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

    @Autowired
    private MisionDAO misionDAO;

    @Autowired
    private CursoEstudianteDAO cursoEstudianteDAO;

    @Autowired
    private MisionEstudianteDAO misionEstudianteDAO;

    @Autowired
    private EstadoDAO estadoDAO;
    //TODO: ESTA MANDANDO ERROR EN NOMBRE_ARCHIVO
    @Override
    public String crearRetoEstudiante(RetoEstudianteDTO retoEstudianteDTO) throws Exception {
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
    }

    @Override
    public List<RetoEstudiante> listar() {
        return retoEstudianteDAO.findAll();
    }

    @Override
    public Double puntajeReto(Long id_estudiante, Long id_curso, Long id_mision) throws Exception{
        List<RetoEstudiante> puntajes = retoEstudianteDAO.puntosRetos(id_estudiante, id_curso, id_mision);
        Double total = 0.0;
        for (RetoEstudiante puntos: puntajes){
            if(puntos.getEstadoTarea().equalsIgnoreCase("Calificado") && puntos.getCalificacion() != null){
                total = total + ((puntos.getCalificacion() * 100)/2);
            }
        }
        return total;
    }


    @Override
    public Double puntajeMision(Long id_curso, Long id_estudiante, Long id_mision) throws Exception {
        MisionEstudiante misionEstudiante =  misionEstudianteDAO.findByIdEstudianteAndIdMision(id_estudiante, id_mision);
        if(misionEstudiante.getEstado().getNombreEstado().equals("Terminada")){
            throw new Exception("La mision ya esta terminada");
        }

        Double totalRetosMision = retoEstudianteDAO.totalRetosPorCursoYMision(id_curso, id_mision);
        Double cursosTerminados = retoEstudianteDAO.retosTerminadosPorMision(id_estudiante, id_curso, id_mision);
        Double resultado =(totalRetosMision/cursosTerminados);
        Double total = puntajeReto(id_estudiante, id_curso, id_mision);
        CursoEstudiante cursoEstudiante = cursoEstudianteDAO.findaByIdEstudianteAndIdCUrso(id_estudiante, id_curso);

        if(cursoEstudiante.getPuntaje_estuduante() != null) {
            total = total + cursoEstudiante.getPuntaje_estuduante();
        }

            if (resultado == 1){
                Mision mision = misionDAO.findById(id_mision).get();
                Integer puntajeMision = mision.getPuntajeMision();
                total = total + puntajeMision;
                misionEstudiante.setEstado(estadoDAO.findById(4L).get());
                misionEstudianteDAO.save(misionEstudiante);
            }

        cursoEstudiante.setPuntaje_estuduante(total);
        cursoEstudianteDAO.save(cursoEstudiante);
        return total;
    }

    @Override
    public String observacionReto(String observacion, Long idEstudiante, Long idReto) throws Exception {
        RetoEstudiante retoEstudiante = retoEstudianteDAO.findByIdEstudianteAndIdReto(idReto, idEstudiante);
        if(observacion.length() >= 501){
            throw new Exception("No debe superar los 500 caracteres");
        }
        retoEstudiante.setObservacion(observacion);
        retoEstudianteDAO.save(retoEstudiante);
        return "Se agrego el comentario correctamente";
    }
}
