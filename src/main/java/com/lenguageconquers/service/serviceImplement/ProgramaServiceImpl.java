package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.DepartamentoDAO;
import com.lenguageconquers.dao.ProgramaDAO;
import com.lenguageconquers.model.Programa;
import com.lenguageconquers.model.dto.ProgramaDTO;
import com.lenguageconquers.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
@Scope("singleton")
@Service
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    private ProgramaDAO programaDAO;

    @Autowired
    private DepartamentoDAO departamentoDAO;


    @Override
    public String crearPrograma(ProgramaDTO programaDTO) {
        try {
            Programa programa = new Programa();
            programa.setNombrePrograma(programaDTO.getNombrePrograma());
            programa.setDepartamento(departamentoDAO.findById(programaDTO.getIdDepartamento()).get());
            programaDAO.save(programa);
            return "Se creo exitosamente el programa";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Programa> listaProgramasPorDepartamento(Long idDepartamento) {
        return programaDAO.findAll();
    }

}
