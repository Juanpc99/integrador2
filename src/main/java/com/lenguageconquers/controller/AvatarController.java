package com.lenguageconquers.controller;


import java.util.List;


import com.lenguageconquers.mapper.AvatarMapper;
import com.lenguageconquers.model.Avatar;
import com.lenguageconquers.model.dto.AvatarDTO;
import com.lenguageconquers.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/avatar")
public class AvatarController {


    @Autowired
    private AvatarService avatarService;

    @Autowired
    private AvatarMapper avatarMapper;

    @GetMapping
    public ResponseEntity<List<AvatarDTO>> listar(){
        List<Avatar> avatarList = avatarService.listar();
        List<AvatarDTO> avatarDTOS = avatarMapper.listAvatarToListAvatarDTO(avatarList);
        System.out.println(avatarList);
        return ResponseEntity.ok().body(avatarDTOS);
    }


    @PostMapping("/guardarAvatar")
    public ResponseEntity<String> save(@RequestBody AvatarDTO avatarDTO){
        try {
            return new ResponseEntity<>(avatarService.registrar(avatarDTO), HttpStatus.CREATED);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/actualizarAvatar")
    public ResponseEntity<Avatar> modificar(@RequestBody Avatar avatar){
        try{
            return new ResponseEntity<>(avatarService.actualizar(avatar), HttpStatus.OK);
        }catch (Exception e){
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminarAvatar/{id}")
    public ResponseEntity<?> eliminarAvatar(@PathVariable("id") Long id){
        try {
            avatarService.eliminar(id);
            return ResponseEntity.ok("Se eliminó satisfactoriamente");
        } catch (Exception e) {
            String mensaje = e.getMessage();
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
    }

    /**
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Avatar listarId(@PathVariable("id") Integer id) {
        Avatar avatar = avatarService.listarId(id);
        if (avatar == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }

        return avatar;
    }
    */
}
