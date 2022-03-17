package com.lenguageconquers.controller;


import java.util.List;


import com.lenguageconquers.mapper.AvatarMapper;
import com.lenguageconquers.model.Avatar;
import com.lenguageconquers.model.dto.AvatarDTO;
import com.lenguageconquers.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
        List<AvatarDTO> avatarDTOS =avatarMapper.listAvatarToListAvatarDTO(avatarList);
        System.out.println(avatarList);
        return ResponseEntity.ok().body(avatarDTOS);
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
