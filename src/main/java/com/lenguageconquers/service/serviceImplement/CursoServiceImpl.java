package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.*;
import com.lenguageconquers.model.Curso;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.Reto;
import com.lenguageconquers.model.dto.CursoDTO;
import com.lenguageconquers.model.dto.RetoDTO;
import com.lenguageconquers.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoDAO cursoDAO;

    @Autowired
    private ProgramaDAO programaDAO;

    @Autowired
    private ProfesorDAO profesorDAO;

    @Autowired
    private EstadoDAO estadoDAO;

    @Autowired
    private CursoEstudianteDAO cursoEstudianteDAO;

    @Override
    public String registrarCurso(CursoDTO cursoDTO) {
        try{
            Curso curso = new Curso();
            curso.setNombreCurso(cursoDTO.getNombreCurso());
            curso.setInicioCurso(cursoDTO.getInicioCurso());
            curso.setFinCurso(cursoDTO.getFinCurso());
            curso.setCantidadEstudiantes(cursoDTO.getCantidadEstudiantes());
            curso.setPassword(cursoDTO.getPassword());
            curso.setProfesor(profesorDAO.findById(cursoDTO.getIdProfesor()).get());
            curso.setEstado(estadoDAO.findById(cursoDTO.getIdEstado()).get());
            curso.setPrograma(programaDAO.findById(cursoDTO.getIdPrograma()).get());
            cursoDAO.save(curso);
            return "Se creo exitosamente el curso";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Curso> listaCursos() {
        List<Curso> c = cursoDAO.findAll();
        return c;
    }


    @Override
    public CursoDTO findById(Long idCurso, Long idEstudiante) throws Exception {
        CursoDTO cursoDTO = new CursoDTO();
        Curso curso = new Curso();
        List<RetoDTO> retoDTOList = new ArrayList<>();
        CursoEstudiante cursoEstudiante = cursoEstudianteDAO.buscarIdCursoyIdEstudiante(idCurso,idEstudiante);
        if(cursoEstudiante == null){
            return cursoDTO;
        }
        curso = cursoDAO.findById(idCurso).get();
        cursoDTO.setIdCurso(curso.getIdCurso());
        cursoDTO.setNombreCurso(curso.getNombreCurso());
        cursoDTO.setIdProfesor(curso.getProfesor().getId());
        cursoDTO.setIdPrograma(curso.getPrograma().getIdPrograma());
        cursoDTO.setInicioCurso(curso.getInicioCurso());
        cursoDTO.setFinCurso(curso.getFinCurso());
        cursoDTO.setCantidadEstudiantes(curso.getCantidadEstudiantes());
        cursoDTO.setPassword(curso.getPassword());
        cursoDTO.setIdEstado(curso.getEstado().getIdEstado());
        for (Reto reto: curso.getRetos()) {
            RetoDTO retoDTO = new RetoDTO();
            retoDTO.setIdReto(reto.getIdReto());
            retoDTO.setDescripcionReto(reto.getDescripcionReto());
            retoDTO.setTituloReto(reto.getTituloReto());
            retoDTO.setFechaInicio(reto.getFechaInicio());
            retoDTO.setFechaLimite(reto.getFechaLimite());
            retoDTO.setMaximoIntentos(reto.getMaximoIntentos());
            retoDTOList.add(retoDTO);
        }
        cursoDTO.setRetoDTOS(retoDTOList);
        return cursoDTO;
    }



/*
    @Override
    public CursoDTO findByIdCurso(Long idCurso) {
        CursoDTO cursoDTO = new CursoDTO();
        Curso curso = cursoDAO.findById(idCurso).get();
        cursoDTO.setIdCurso(curso.getIdCurso());
        cursoDTO.setInicioCurso(curso.getInicioCurso());
        cursoDTO.setFinCurso(curso.getFinCurso());
        cursoDTO.setNombreCurso(curso.getNombreCurso());
        cursoDTO.setCantidadEstudiantes(curso.getCantidadEstudiantes());
        cursoDTO.setIdEstado(curso.getEstado().getIdEstado());
        cursoDTO.setIdPrograma(curso.getPrograma().getIdPrograma());
        cursoDTO.setPassword(curso.getPassword());

        return cursoDTO;
    }

 */


}
