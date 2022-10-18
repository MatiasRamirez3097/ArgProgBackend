/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Controller;

import com.ramirezmatias.mgr.Dto.DtoEducacion;
import com.ramirezmatias.mgr.Entity.Educacion;
import com.ramirezmatias.mgr.Security.Controller.Mensaje;
import com.ramirezmatias.mgr.Service.EduService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matia
 */

@RestController
@RequestMapping("/edu")
@CrossOrigin(origins = "https://frontendmgr-14d4e.web.ap")
public class EducacionController {
    @Autowired
    EduService eduService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>>List(){
        List<Educacion> list = eduService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!eduService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        Educacion edu = eduService.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!eduService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        eduService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado!"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion){
        if(StringUtils.isBlank(dtoEducacion.getNombreEdu()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
        if(eduService.existsByNombreEdu(dtoEducacion.getNombreEdu()))
            return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);
        Educacion edu = new Educacion(dtoEducacion.getNombreEdu(), dtoEducacion.getDescEdu());
        eduService.save(edu);
        return new ResponseEntity(new Mensaje("creada!"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
        if(!eduService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(eduService.existsByNombreEdu(dtoEducacion.getNombreEdu()) && eduService.getByNombreEdu(dtoEducacion.getNombreEdu()).get().getId()!= id)
            return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEducacion.getNombreEdu()) && StringUtils.isBlank(dtoEducacion.getDescEdu()))
            return new ResponseEntity(new Mensaje("Los campos no pueden estar vacios"),HttpStatus.BAD_REQUEST);
        Educacion edu = eduService.getOne(id).get();
        
        edu.setNombreEdu(dtoEducacion.getNombreEdu());
        edu.setDescEdu(dtoEducacion.getDescEdu());
        
        eduService.save(edu);
        
        return new ResponseEntity(new Mensaje("Actualizada"),HttpStatus.OK);
    }
}