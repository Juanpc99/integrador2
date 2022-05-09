package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.DepartamentoDAO;
import com.lenguageconquers.dao.ProgramaDAO;
import com.lenguageconquers.model.ArchivoEstudiante;
import com.lenguageconquers.model.Programa;
import com.lenguageconquers.model.dto.ArchivosEstudianteDTO;
import com.lenguageconquers.model.dto.ProgramaDTO;
import com.lenguageconquers.service.ProgramaService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Scope("singleton")
@Service
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    private ProgramaDAO programaDAO;

    @Autowired
    private DepartamentoDAO departamentoDAO;


    @Override
    public String crearPrograma(ProgramaDTO programaDTO) throws Exception {
        Programa programa = new Programa();
        if(programaDTO.getIdDepartamento() == null){
            throw new Exception("Debe ingresar un id de departamento");
        }
        if(programaDTO.getIdDepartamento()<0){
            throw new Exception("Debe ingresar un id mayor a 0");
        }
        if(departamentoDAO.findById(programaDTO.getIdDepartamento()).toString().equals("Optional.empty")){
            throw new Exception("No se encontro ningun departamento con ese id");
        }
        if(programaDTO.getNombrePrograma() == null || programaDTO.getNombrePrograma().trim().equals("")){
            throw new Exception("Debe ingresar un nombre para el programa");
        }
        if(programaDTO.getNombrePrograma().length()>50){
            throw new Exception("El nombre del programa es muy largo");
        }
        programa.setNombrePrograma(programaDTO.getNombrePrograma());
        programa.setDepartamento(departamentoDAO.findById(programaDTO.getIdDepartamento()).get());
        programaDAO.save(programa);
        return "Se creo exitosamente el programa";

    }

    @Override
    public List<ProgramaDTO> listaProgramasPorDepartamento(Long idDepartamento) throws Exception {
        List<Programa> programas = programaDAO.findByIdDepartamento(idDepartamento);
        List<ProgramaDTO> programaDTOS = new ArrayList<>();
        for (Programa programa: programas){
            ProgramaDTO programaDTO = new ProgramaDTO();
            programaDTO.setIdPrograma(programa.getIdPrograma());
            programaDTO.setNombrePrograma(programa.getNombrePrograma());
            programaDTO.setIdDepartamento(programa.getDepartamento().getIdDepartamento());
            programaDTOS.add(programaDTO);
        }
        return programaDTOS;
    }


}
