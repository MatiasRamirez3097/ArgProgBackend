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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author matia
 */
@Controller
@RequestMapping("exp")
@CrossOrigin("https://frontendmgr-14d4e.web.ap")
public class ExperienciaController {
    @Autowired
    ExpService expService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = expService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreExp()))
           return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
        if(expService.existsByNombreExp(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Esa Experiencia existe"),HttpStatus.BAD_REQUEST);
        Experiencia exp = new Experiencia(dtoExp.getNombreExp(), dtoExp.getDescExp());
        expService.save(exp);
        
        return new ResponseEntity(new Mensaje("Experiencia cargada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExp) {
        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.BAD_REQUEST);
        if(expService.existsByNombreExp(dtoExp.getNombreExp()) && expService.getByNombreExp(dtoExp.getNombreExp()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        
        Experiencia exp = expService.getOne(id).get();
        exp.setNombreExp(dtoExp.getNombreExp());
        exp.setDescExp(dtoExp.getDescExp());
        
        expService.save(exp);
        return new ResponseEntity(new Mensaje("Experiencia actualizada!"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("ID inexistente"),HttpStatus.BAD_REQUEST);
        expService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia>getById(@PathVariable("id") int id){
        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("Inexistente"),HttpStatus.NOT_FOUND);
        Experiencia exp = expService.getOne(id).get();
        return new ResponseEntity(exp, HttpStatus.OK);
    }
}
