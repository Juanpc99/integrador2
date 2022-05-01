package com.lenguageconquers.service.serviceImplement;

import com.lenguageconquers.dao.BitacoraDAO;
import com.lenguageconquers.dao.EstudianteDAO;
import com.lenguageconquers.model.Bitacora;
import com.lenguageconquers.model.CursoEstudiante;
import com.lenguageconquers.model.dto.BitacoraDTO;
import com.lenguageconquers.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Scope("singleton")
@Service
public class BitacoraServiceImpl implements BitacoraService {

    @Autowired
    private BitacoraDAO bitacoraDAO;

    @Autowired
    private EstudianteDAO estudianteDAO;

    @Override
    public String guardarRegistro(BitacoraDTO bitacoraDTO) throws Exception {
        Bitacora bitacora = new Bitacora();
        bitacora.setEstudiante(estudianteDAO.findById(bitacoraDTO.getIdEstudiante()).get());
        bitacora.setFechaIngreso(bitacoraDTO.getFechaIngreso());
        bitacora.setFechaSalida(bitacoraDTO.getFechaSalida());


//        if(bitacoraDTO.getFechaIngreso().isAfter(LocalDate.now())){
//            throw new Exception("La fecha no puede ser antes a la actual");
//        }
        if(!estudianteDAO.existsById(bitacoraDTO.getIdEstudiante())){
            throw new Exception("El estudiante no existe");
        }
        bitacoraDAO.save(bitacora);
        return "Se guardo el registro exitosamente";
    }

    @Override
    public String actualizarRegistro(BitacoraDTO bitacoraDTO) throws Exception {
        Bitacora bitacora = bitacoraDAO.findById(bitacoraDTO.getIdBitacora()).get();
        bitacora.setIdBitacora(bitacoraDTO.getIdBitacora());
        bitacora.setEstudiante(estudianteDAO.findById(bitacoraDTO.getIdEstudiante()).get());
        bitacora.setFechaSalida(bitacoraDTO.getFechaSalida());

        if(!bitacoraDAO.existsById(bitacora.getIdBitacora())){
            throw new Exception("El id de la bitacora no existe ");
        }
//        if(bitacoraDTO.getFechaSalida().isAfter(LocalDate.now())){
//            throw new Exception("La fecha no puede ser antes a la actual");
//        }
        if(!estudianteDAO.existsById(bitacoraDTO.getIdEstudiante())){
            throw new Exception("El estudiante no existe");
        }
        bitacoraDAO.save(bitacora);
        return "Se actualizo el registro exitosamente";
    }

    @Override
    public List<BitacoraDTO> listaRegistros(Long idEstudiante) throws Exception {
        List<Bitacora> bitacoraList = bitacoraDAO.findByIdEstudiante(idEstudiante);
        List<BitacoraDTO> bitacoraDTOS = new ArrayList<>();
        for(Bitacora bitacora : bitacoraList){
            BitacoraDTO bitacoraDTO = new BitacoraDTO();
            bitacoraDTO.setIdBitacora(bitacora.getIdBitacora());
            bitacoraDTO.setFechaIngreso(bitacora.getFechaIngreso());
            bitacoraDTO.setFechaSalida(bitacora.getFechaSalida());
            bitacoraDTO.setIdEstudiante(bitacora.getEstudiante().getIdEstudiante());
            bitacoraDTOS.add(bitacoraDTO);
        }
        return bitacoraDTOS;
    }


}
