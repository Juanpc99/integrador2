package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.ArchivoDAO;
import com.lenguageconquers.dao.ArchivoEstudianteDAO;
import com.lenguageconquers.dao.EstudianteDAO;
import com.lenguageconquers.model.ArchivoEstudiante;
import com.lenguageconquers.model.dto.ArchivosEstudianteDTO;
import com.lenguageconquers.service.ArchivoEstudianteService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Scope("singleton")
@Service
public class ArchivoEstudianteServiceImpl implements ArchivoEstudianteService {

    @Autowired
    private ArchivoEstudianteDAO archivoEstudianteDAO;

    @Autowired
    private ArchivoDAO archivoDAO;

    @Autowired
    private EstudianteDAO estudianteDAO;

    @Override
    public List<ArchivoEstudiante> listar() {
        return archivoEstudianteDAO.findAll();
    }

    @Override
    public List<ArchivoEstudiante> listarPorId(Long idEstudiante) throws Exception{
        ArchivosEstudianteDTO archivosEstudianteDTO = new ArchivosEstudianteDTO();
        if(Validaciones.isIdNull(idEstudiante)){
            throw new Exception("Debe ingresar el id del estudiante");
        }
        List<ArchivoEstudiante> archivoEstudiantes = (List<ArchivoEstudiante>) archivoEstudianteDAO.findById(archivosEstudianteDTO.getIdEstudiante()).get();
        if(archivoEstudiantes.isEmpty()){
            throw new Exception("El estudiante no ha subido archivos");
        }
        return archivoEstudiantes;
    }

    @Override
    public String subirArchivoEstudiante(ArchivosEstudianteDTO archivosEstudianteDTO) throws Exception {

        ArchivoEstudiante archivoEstudiante = new ArchivoEstudiante();
        if(estudianteDAO.findById(archivosEstudianteDTO.getIdEstudiante()).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del estudiante valido");
        }
        if(archivoDAO.findById(archivosEstudianteDTO.getIdArchivo()).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del archivo valido");
        }
        if(archivosEstudianteDTO.getIdEstudiante() == null ||archivosEstudianteDTO.getIdEstudiante() <=0){
            throw new Exception("Se debe ingresar un id del estudiante");
        }
        if( archivosEstudianteDTO.getIdEstudiante().toString().length()>3){
            throw new Exception("El id del estudiante es muy largo, no es valido");
        }
        if(archivosEstudianteDTO.getIdArchivo() == null || archivosEstudianteDTO.getIdArchivo() <= 0){
            throw new Exception("Se debe ingresar un id del archivo");
        }
        if( archivosEstudianteDTO.getIdArchivo().toString().length()>3){
            throw new Exception("El id del archivo es muy largo, no es valido");
        }
        if(archivosEstudianteDTO.getDescripcion() == null || archivosEstudianteDTO.getDescripcion().trim().equals("")){
            throw new Exception("Se debe ingresar una descripcion del archivo");
        }
        if(archivosEstudianteDTO.getDescripcion().length() >150){
            throw new Exception("La descripcion del archivo es muy larga");
        }
        if(archivosEstudianteDTO.getFecaCreacion() == null){
            throw new Exception("Se debe ingresar una fecha de creacion");
        }
        Date fecha = new Date();
        if(archivosEstudianteDTO.getFecaCreacion().compareTo(fecha)<0){
            throw new Exception("La fecha de creación no debe ser superior a la fecha actual");
        }

        archivoEstudiante.setArchivo(archivoDAO.findById(archivosEstudianteDTO.getIdArchivo()).get());
        archivoEstudiante.setEstudiante(estudianteDAO.findById(archivosEstudianteDTO.getIdEstudiante()).get());
        archivoEstudiante.setDescripcion(archivosEstudianteDTO.getDescripcion());
        archivoEstudiante.setFecaCreacion(archivosEstudianteDTO.getFecaCreacion());
        archivoEstudianteDAO.save(archivoEstudiante);
        return "Se creo exitosamente el archivo estudiante";
    }

}
