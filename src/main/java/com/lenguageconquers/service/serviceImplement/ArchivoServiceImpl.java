package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.ArchivoDAO;
import com.lenguageconquers.dao.CursoDAO;
import com.lenguageconquers.dao.ProfesorDAO;
import com.lenguageconquers.model.Archivo;
import com.lenguageconquers.model.dto.ArchivosDTO;
import com.lenguageconquers.service.ArchivoService;
import com.lenguageconquers.util.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Scope("singleton")
@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private ArchivoDAO archivoDAO;

    @Autowired
    private CursoDAO cursoDAO;

    @Autowired
    private ProfesorDAO profesorDAO;

    @Override
    public List<Archivo> listar() {
        return archivoDAO.findAll();
    }

    @Override
    public String subirArchivo(ArchivosDTO archivosDTO) throws Exception {
        Archivo archivo = new Archivo();
        if( archivosDTO.getIdCurso().toString().length()>3){
            throw new Exception("El id del curso es muy largo, no es valido");
        }
        if( archivosDTO.getIdProfesor().toString().length()>3){
            throw new Exception("El id del curso es muy largo, no es valido");
        }

        if(archivosDTO.getIdCurso() == null || archivosDTO.getIdCurso() <=0){
            throw new Exception("Se debe ingresar un id de curso");
        }

        if(archivosDTO.getIdProfesor() == null || archivosDTO.getIdProfesor() <= 0){
            throw new Exception("Se debe ingresar un id de profesor");
        }
        if(cursoDAO.findById(archivosDTO.getIdCurso()).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del curso valido");
        }
        if(profesorDAO.findById(archivosDTO.getIdProfesor()).toString().equals("Optional.empty")){
            throw new Exception("Se debe ingresar el id del profesor valido");
        }

        if(archivosDTO.getArchivo() == null || archivosDTO.getArchivo().trim().equals("")){
            throw new Exception("Se debe ingresar un archivo");
        }
        if(archivosDTO.getArchivo().length() >500){
            throw new Exception("El nombre del archivo es muy largo");
        }
        if(archivosDTO.getFechaCreacion() == null){
            throw new Exception("Se debe ingresar una fecha");
        }
            //TODO:REVISAR LA COMPARACION PORQUE DEJA INGRESAR FECHAS PASADAS
        if(archivosDTO.getFechaCreacion().compareTo(new Date())>0){
            throw new Exception("La fecha de creación no debe ser superior a la fecha actual");
        }
        if(archivosDTO.getTitulo() == null || archivosDTO.getTitulo().trim().equals("")){
            throw new Exception("Se debe ingresar el nombre del archivo");
        }
        if(archivosDTO.getTitulo().length() > 50){
            throw new Exception("El nombre del archivo es muy largo");
        }
        if(!Validaciones.isExtensionValid(archivosDTO.getArchivo())){
            throw new Exception("El tipo o extension de archivo no es valido");
        }
        archivo.setArchivo(archivosDTO.getArchivo());
        archivo.setFechaCreacion(archivosDTO.getFechaCreacion());
        archivo.setTitulo(archivosDTO.getTitulo());
        archivo.setCurso(cursoDAO.findById(archivosDTO.getIdCurso()).get());
        archivo.setProfesor(profesorDAO.findById(archivosDTO.getIdProfesor()).get());
        archivoDAO.save(archivo);
        return "Se ha guardado exitosamente el archivo";
    }
}
