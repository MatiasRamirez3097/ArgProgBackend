/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Controller;

import com.ramirezmatias.mgr.Dto.DtoExperiencia;
import com.ramirezmatias.mgr.Entity.Experiencia;
import com.ramirezmatias.mgr.Security.Controller.Mensaje;
import com.ramirezmatias.mgr.Service.ExpService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author matia
 */
@Controller
@RequestMapping("exp")
@CrossOrigin("http://localhost:4200")
public class ExperienciaController {
    @Autowired
    ExpService expService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = expService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreExp()))
           return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
    }
}
