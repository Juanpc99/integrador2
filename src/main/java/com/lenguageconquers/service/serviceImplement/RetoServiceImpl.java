package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.*;
import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.dto.RetoDTO;
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
public class RetoServiceImpl implements RetoService {

    @Autowired
    private RetosDAO retosDAO;

    @Autowired
    private EstadoDAO estadoDAO;

    @Autowired
    private EstadoTipoDAO estadoTipoDAO;

    @Autowired
    private CursoDAO cursoDAO;

    @Autowired
    private MisionDAO misionDAO;

    @Autowired
    private CursoEstudianteDAO cursoEstudianteDAO;

    @Override
    public String actualizarEstado(RetoDTO retoDTO) throws Exception {
            Reto reto = null;
            if(retoDTO.getIdReto() == null){
                throw new Exception("Debe ingresar el id del reto que desea actualizar");
            }
            if(!retosDAO.existsById(retoDTO.getIdReto())){
                throw new Exception("No existe un reto con ese id");
            }
            if(retoDTO.getIdEstado() == null){
                throw new Exception("Debe ingresar el id del estado");
            }
            if(retoDTO.getIdEstado()<0){
                throw new Exception("El id del estado no puede ser menor a 0");
            }
            if(estadoDAO.findById(retoDTO.getIdEstado()).toString().equals("Optional.empty")){
                throw new Exception("No se encontro el id de estado, ingrense uno valido");
            }
            if(!estadoDAO.findById(retoDTO.getIdEstado()).get().getEstadoTipo().getIdEstadoTipo().equals(1L)){
                throw new Exception("Debe ingresar un id de estado que sea de tipo reto");
            }

            reto = retosDAO.findById(retoDTO.getIdReto()).get();
            reto.setEstado(estadoDAO.findById(retoDTO.getIdEstado()).get());
            retosDAO.save(reto);
            return "Se actualizo el id del estado en el reto";

    }

    @Override
    public List<RetoDTO> listar() throws Exception{
        List<Reto> retos = retosDAO.findAll();
        if(retos.isEmpty()){
            throw new Exception("No hay retos registrados");
        }
        List<RetoDTO> retoDTOList = mapeoFroReto(retos);
        return retoDTOList;
    }

    @Override
    public Reto findByIdReto(Long idReto) throws Exception {
        if(idReto == null){
            throw new Exception("Se debe ingresar el id del reto");
        }
        if(!retosDAO.findById(idReto).isPresent()){
            throw new Exception("No existe el reto");
        }
        return retosDAO.findById(idReto).get();
    }

    @Override
    public boolean elRetoEsGrupal(Long idReto) throws Exception {
        RetoDTO retoDTO = new RetoDTO();
        if(idReto == null){
            throw new Exception("Debe ingresar el id de un reto");
        }
        Boolean resp = retosDAO.findById(idReto).equals(retoDTO.isEsGrupal());
        System.out.println(resp);
        if(resp){
            return true;
        }else{
            return  false;
        }


    }

    @Override
    public List<RetoDTO> findByIdCursoAndIdMision(Long idCurso, Long idMision) throws Exception {
        if(!cursoDAO.findById(idCurso).isPresent()){
            throw new Exception("El id curso no existe");
        }
        if(!misionDAO.findById(idMision).isPresent()){
            throw new Exception("El id mision no existe");
        }
        List<Reto> retos = retosDAO.findByIdCursoAndIdMision(idCurso, idMision);
        List<RetoDTO> retoDTOList = mapeoFroReto(retos);
        return retoDTOList;
    }

    @Override
    public String agregarReto(RetoDTO retoDTO) throws Exception {

        if(retoDTO.getDescripcionReto().length() > 500){
            throw new Exception("No debe ingresar mas de 500 caracteres en la descripcion");
        }
        if(retoDTO.getTituloReto().length() > 100){
            throw new Exception("No debe ingresar mas de 100 caracteres en el titulo");
        }
        if(retoDTO.getMaximoIntentos() >= 11 || retoDTO.getMaximoIntentos() <= 0){
            throw new Exception("Los intentos no deben ser menores a 1 o mayores a 10");
        }
        if(!misionDAO.existsById(retoDTO.getIdMision())){
            throw new Exception("El id de la mision no existe");
        }
        if(!estadoDAO.existsById(retoDTO.getIdEstado())){
            throw new Exception("El id del estado no existe");
        }
        if(!cursoDAO.existsById(retoDTO.getIdCurso())){
            throw new Exception("El id del curso no existe");
        }
        Date fecha = new Date();
        if(retoDTO.getFechaInicio().compareTo(fecha) < 0){
            throw new Exception("La fecha no debe ser menor a la fecha actual");
        }
        if(retoDTO.getFechaLimite().compareTo(retoDTO.getFechaInicio()) <= 0){
            throw new Exception("La fecha limite no debe ser el mismo dia o antes de la fecha de inicio");
        }
        if(Validaciones.tiempoEntreFechas(retoDTO.getFechaInicio(), retoDTO.getFechaLimite()) >= 4){
            throw new Exception("No debe haber mas de 4 meses de diferencias entre las fechas");
        }
        if(retoDTO.isEsGrupal() == true && retoDTO.getCantidadEstudiantesGrupos()<2){
            throw new Exception("Debe ingresar el atributo de cantidadEstudiantesGrupos y como minimo 2 para crear retos grupales");
        }
        if(retoDTO.isEsGrupal() == false && retoDTO.getCantidadEstudiantesGrupos()>=0){
            throw new Exception("Los retos que no son grupales no deben de tener cantidad estudiantes para el grupo");
        }
        Reto reto = mapeoRetoDTO(retoDTO);
        retosDAO.save(reto);
        return "Se guardo exitosamente";
    }

    @Override
    public String actualizarReto(RetoDTO retoDTO) throws Exception {
        if(!retosDAO.existsById(retoDTO.getIdReto())){
            throw new Exception("No existe un reto con ese id");
        }
        agregarReto(retoDTO);
        return "Se actualizo exitosamente";
    }

    @Override
    public String eliminarReto(Long idReto) throws Exception {
        if(idReto == null){
            throw new Exception("Debe ingresar el id del reto");
        }
        if(retosDAO.existsById(idReto) == false){
            throw new Exception("El reto con id " + idReto + " no existe");
        }
        retosDAO.findById(idReto).ifPresent(reto -> {
            if(reto.getRetoEstudiantes().isEmpty() == false){
                throw new RuntimeException("Todavia hay estudiantes asignados a este reto");
            }
        });

        retosDAO.deleteById(idReto);
        return "El reto se elimino exitosamente";
    }


    private RetoDTO mapeoReto(Reto reto){
        RetoDTO retoDTO = new RetoDTO();
        retoDTO.setIdReto(reto.getIdReto());
        retoDTO.setDescripcionReto(reto.getDescripcionReto());
        retoDTO.setTituloReto(reto.getTituloReto());
        retoDTO.setFechaInicio(reto.getFechaInicio());
        retoDTO.setFechaLimite(reto.getFechaLimite());
        retoDTO.setEsGrupal(reto.isEsGrupal());
        retoDTO.setCantidadEstudiantesGrupos(reto.getCantidadEstudiantesGrupos());
        retoDTO.setMaximoIntentos(reto.getMaximoIntentos());
        retoDTO.setIdMision(reto.getMision().getIdMision());
        retoDTO.setIdEstado(reto.getEstado().getIdEstado());
        retoDTO.setIdCurso(reto.getCurso().getIdCurso());

        return retoDTO;
    }
    private Reto mapeoRetoDTO(RetoDTO retoDTO){
        Reto reto = new Reto();
        reto.setIdReto(retoDTO.getIdReto());
        reto.setDescripcionReto(retoDTO.getDescripcionReto());
        reto.setTituloReto(retoDTO.getTituloReto());
        reto.setFechaInicio(retoDTO.getFechaInicio());
        reto.setFechaLimite(retoDTO.getFechaLimite());
        reto.setMaximoIntentos(retoDTO.getMaximoIntentos());
        reto.setEsGrupal(retoDTO.isEsGrupal());
        reto.setCantidadEstudiantesGrupos(retoDTO.getCantidadEstudiantesGrupos());
        reto.setMision(misionDAO.findById(retoDTO.getIdMision()).get());
        reto.setEstado(estadoDAO.findById(retoDTO.getIdEstado()).get());
        reto.setCurso(cursoDAO.findById(retoDTO.getIdCurso()).get());

        return reto;
    }
    private List<RetoDTO> mapeoFroReto(List<Reto> retos){
        List<RetoDTO> retoDTOList = new ArrayList<>();
        for (Reto reto: retos){
            RetoDTO retoDTO = mapeoReto(reto);
            retoDTOList.add(retoDTO);
        }
        return retoDTOList;
    }
}
