package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.*;
import com.lenguageconquers.model.*;
import com.lenguageconquers.model.dto.RetoDTO;
import com.lenguageconquers.model.dto.RetoEstudianteDTO;
import com.lenguageconquers.service.RetoEstudianteService;
import com.lenguageconquers.service.RetoService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private GruposDAO gruposDAO;

    @Autowired
    private RolDAO rolDAO;

    @Autowired
    private RetoService retoService;

    @Autowired
    private RolRetoDAO rolRetoDAO;


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
        if(retoEstudianteDTO.getCalificacion() <0){
            throw new Exception("La calificación no debe ser menor a 0");
        }
        if(cursoEstudianteDAO.nivelEstudiante(retoEstudianteDTO.getIdReto(), retoEstudianteDTO.getIdEstudiante())<2){
            throw new Exception("No se puede asignar un reto grupal si no esta en el nivel 2 o superior");
        }
        if(retoEstudianteDTO.getIdRol() != null && retoEstudianteDTO.getIdGrupo() != null){
            if(gruposDAO.findById(retoEstudianteDTO.getIdGrupo()).toString().equals("Optional.empty")){
                throw new Exception("No se encontro el id del grupo, ingrese uno valido");
            }
            if(rolDAO.findById(retoEstudianteDTO.getIdRol()).toString().equals("Optional.empty")){
                throw new Exception("No se encontro el id del rol, ingrese uno valido");
            }
            if(rolRetoDAO.buscarPorRolReto(retoEstudianteDTO.getIdReto(), retoEstudianteDTO.getIdRol()).isEmpty()){

                throw new Exception("El rol no esta asociado al reto al que usted pertenece, ingrese un id valido");
            }
            if(listarPorRetoGrupoRol(retoEstudianteDTO.getIdGrupo(), retoEstudianteDTO.getIdReto(),retoEstudianteDTO.getIdRol())) {
                throw new Exception("No puedes seleccionar ese rol, ya esta asignado en ese grupo");
            }

            retoEstudiante.setRol(rolDAO.findById(retoEstudianteDTO.getIdRol()).get());
            retoEstudiante.setGrupos(gruposDAO.findById(retoEstudianteDTO.getIdGrupo()).get());
        }
        retoEstudiante.setEstudiante(estudianteDAO.findById(retoEstudianteDTO.getIdEstudiante()).get());
        retoEstudiante.setReto(retosDAO.findById(retoEstudianteDTO.getIdReto()).get());
        retoEstudiante.setNombreArchivo(retoEstudianteDTO.getNombreArchivo());
        retoEstudiante.setUrlArchivo(retoEstudianteDTO.getUrlArchivo());
        retoEstudiante.setEstadoTarea(retoEstudianteDTO.getEstadoTarea());
        retoEstudiante.setFechaSubida(retoEstudianteDTO.getFechaSubida());
        retoEstudiante.setObservacion(retoEstudianteDTO.getObservacion());
        retoEstudiante.setCalificacion(retoEstudianteDTO.getCalificacion());

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

    @Override
    public boolean listarPorRetoGrupoRol(Long idGrupo, Long idReto, Long idRol) throws Exception {
        List<RetoEstudiante> retoEstudiante = retoEstudianteDAO.findByIdGrupoAndIdReto(idGrupo, idReto, idRol);
        if(retoEstudiante.size() >=1){
            return true;
        }else{
            return false;
        }

    }

    private RetoEstudianteDTO mapeoRetoEstudiante(RetoEstudiante retoEstudiante){
        RetoEstudianteDTO retoEstudianteDTO = new RetoEstudianteDTO();
        retoEstudianteDTO.setIdRetoEstudiante(retoEstudiante.getIdRetoEstudiante());
        retoEstudianteDTO.setIdEstudiante(retoEstudiante.getIdRetoEstudiante());
        retoEstudianteDTO.setIdGrupo(retoEstudiante.getGrupos().getIdGrupo());
        retoEstudianteDTO.setIdReto(retoEstudiante.getReto().getIdReto());
        retoEstudianteDTO.setEstadoTarea(retoEstudiante.getEstadoTarea());
        retoEstudianteDTO.setFechaSubida(retoEstudiante.getFechaSubida());
        retoEstudianteDTO.setUrlArchivo(retoEstudiante.getUrlArchivo());
        retoEstudianteDTO.setCalificacion(retoEstudiante.getCalificacion());
        retoEstudianteDTO.setNombreArchivo(retoEstudiante.getNombreArchivo());
        retoEstudianteDTO.setObservacion(retoEstudiante.getObservacion());

        return retoEstudianteDTO;
    }
    private List<RetoEstudianteDTO> mapeoFroReto(List<RetoEstudiante> retoEstudiantes){
        List<RetoEstudianteDTO> retoDTOList = new ArrayList<>();
        for (RetoEstudiante retos: retoEstudiantes){
            RetoEstudianteDTO retoEstudianteDTO = mapeoRetoEstudiante(retos);
            retoDTOList.add(retoEstudianteDTO);
        }
        return retoDTOList;
    }
}
