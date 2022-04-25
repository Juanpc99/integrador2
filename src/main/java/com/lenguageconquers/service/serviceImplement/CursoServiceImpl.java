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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private EstudianteDAO estudianteDAO;

    @Autowired
    private FacultadDAO facultadDAO;

//    @Autowired
//    private BCryptPasswordEncoder encoder;

    @Override
    public String registrarCurso(CursoDTO cursoDTO) throws Exception {
        Curso curso = new Curso();
        if(cursoDTO.getIdPrograma() == null){
            throw new Exception("Debe ingresar el id de un programa");
        }
        if(cursoDTO.getIdEstado() == null){
            throw new Exception("Debe ingresar el id de un estado");
        }
        if(programaDAO.findById(cursoDTO.getIdPrograma()).toString().equals("Optional.empty")){
            throw new Exception("No se encontro el id de programa, ingrese uno valido");
        }
        if(estadoDAO.findById(cursoDTO.getIdEstado()).toString().equals("Optional.empty")){
            throw new Exception("No se encontro el id de estado, ingrese uno valido");
        }
        if(cursoDTO.getNombreCurso() == null || cursoDTO.getNombreCurso().trim().equals("")){
            throw new Exception("Debe ingresar el nombre del curso");
        }
        if(cursoDTO.getNombreCurso().length()>60){
            throw new Exception("El nombre del curso es muy largo");
        }
        if(cursoDTO.getInicioCurso() == null){
            throw new Exception("Debe ingresar una fecha de inicio del curso");
        }
        if(cursoDTO.getFinCurso() == null){
            throw new Exception("Debe ingresar una fecha de finalización del curso");
        }
        if(cursoDTO.getCantidadEstudiantes()<0){
            throw new Exception("Debe ingresar un numero mayor que 0 en la cantidad de estudiantes");
        }

        curso.setNombreCurso(cursoDTO.getNombreCurso());
        curso.setInicioCurso(cursoDTO.getInicioCurso());
        curso.setFinCurso(cursoDTO.getFinCurso());
        curso.setCantidadEstudiantes(cursoDTO.getCantidadEstudiantes());
        curso.setProfesor(profesorDAO.findById(cursoDTO.getIdProfesor()).get());
        curso.setEstado(estadoDAO.findById(cursoDTO.getIdEstado()).get());
        curso.setPrograma(programaDAO.findById(cursoDTO.getIdPrograma()).get());
        curso.setPassword(cursoDTO.getPassword());
        cursoDAO.save(curso);
        return "Se creo exitosamente el curso";
    }

    @Override
    public List<CursoDTO> listaCursos() throws Exception{
        List<CursoDTO> cursoDTOList = mapeoForCurso(cursoDAO.findAll());
        return cursoDTOList;
    }


    @Override
    public CursoDTO findById(Long idCurso, Long idEstudiante) throws Exception {

        List<RetoDTO> retoDTOList = new ArrayList<>();
        CursoEstudiante cursoEstudiante = cursoEstudianteDAO.buscarIdCursoyIdEstudiante(idCurso,idEstudiante);

        if(cursoDAO.findById(idCurso).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del curso valido");
        }

        if(estudianteDAO.findById(idEstudiante).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del estudiante valido");
        }

        if(cursoEstudiante == null){
            throw new Exception("No se encuentra matriculado en este curso");
        }
        Curso curso = cursoDAO.findById(idCurso).get();
        CursoDTO cursoDTO = mapeo(curso);
        
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

    @Override
    public List<CursoDTO> encontrarPorIdEstudianteCursosConProgramaIgual(Long idEstudiante) throws Exception{
        List<Curso> cursos = cursoDAO.findByIdEstudianteCursoConProgramaIgual(idEstudiante);
        List<CursoDTO> cursoDTOList = new ArrayList<>();

        if(estadoDAO.findById(idEstudiante).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del estudiante valido");
        }
        if(cursos.size() == 0){
            throw new Exception("El estudiante no tiene cursos disponibles en su programa");
        }
        for (Curso curso: cursos) {
            CursoDTO cursoDTO = mapeo(curso);
            cursoDTOList.add(cursoDTO);
        }
        return cursoDTOList;

    }

    @Override
    public List<CursoDTO> encontrarPorIdFacultad(Long idFacultad) throws Exception {
        List<Curso> cursos = cursoDAO.findByIdFacultad(idFacultad);
        List<CursoDTO> cursoDTOList = new ArrayList<>();
        if(facultadDAO.findById(idFacultad).toString().equals("Optional.empty")){
            throw new Exception("Debe ingresar un id de facultad que si exista");
        }
        if(cursos.size() == 0){
            throw new Exception("No hay cursos asigandos a esa facultad");
        }
        for (Curso curso: cursos) {
            CursoDTO cursoDTO = mapeo(curso);
            cursoDTOList.add(cursoDTO);
        }
        return cursoDTOList;
    }

    @Override
    public List<CursoDTO> encontrarPorIdFacultadeIdEstado(Long idFacultad, Long idEstado) throws Exception {
        if(facultadDAO.findById(idFacultad).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id de facultad valido");
        }
        if(estadoDAO.findById(idEstado).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del estado valido");
        }

        List<Curso> cursos = cursoDAO.findByIdFacultadAndIdEstado(idFacultad, idEstado);
        if(cursos.size() == 0){
            throw new Exception("No hay cursos en la facultad con ese estado");
        }
        List<CursoDTO> cursoDTOList = new ArrayList<>();
        for (Curso curso: cursos) {
            CursoDTO cursoDTO = mapeo(curso);
            cursoDTOList.add(cursoDTO);
        }
        return cursoDTOList;
    }

    @Override
    public Integer progresoCurso(Long idEstudiante, Long idCurso) throws Exception {
        if(estadoDAO.existsById(idEstudiante) == false){
            System.out.printf("Fallo Estudiante");
            throw new Exception("El estudiante no existe");
        }
        if(cursoDAO.existsById(idCurso) == false){
            System.out.printf("Fallo curso");
            throw new Exception("El curso no existe");
        }
        Integer cursos = cursoDAO.findByIdEstudianteAndIdCUrso(idEstudiante, idCurso).size();
        Integer cursosTerminados = cursoDAO.findByIdEstudianteAndIdCUrsoAndEstadoTerminado(idEstudiante, idCurso).size();
        Integer progreso = ((100 * cursosTerminados)/cursos);
        return progreso;
    }

    public CursoDTO mapeo(Curso curso){
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setIdCurso(curso.getIdCurso());
        cursoDTO.setNombreCurso(curso.getNombreCurso());
        cursoDTO.setIdProfesor(curso.getProfesor().getId());
        cursoDTO.setIdPrograma(curso.getPrograma().getIdPrograma());
        cursoDTO.setInicioCurso(curso.getInicioCurso());
        cursoDTO.setFinCurso(curso.getFinCurso());
        cursoDTO.setCantidadEstudiantes(curso.getCantidadEstudiantes());
        cursoDTO.setIdEstado(curso.getEstado().getIdEstado());
        cursoDTO.setPassword(curso.getPassword());
        List<RetoDTO> retoDTOList = new ArrayList<>();
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
    public List<CursoDTO> mapeoForCurso (List<Curso> cursos) {
        List<CursoDTO> cursoDTOList = new ArrayList<>();
        for (Curso curso: cursos) {
            CursoDTO cursoDTO = mapeo(curso);
            cursoDTOList.add(cursoDTO);
        }
        return cursoDTOList;
    }






}
