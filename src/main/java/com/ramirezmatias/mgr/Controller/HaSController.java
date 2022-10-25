/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Controller;

import com.ramirezmatias.mgr.Dto.DtoHaS;
import com.ramirezmatias.mgr.Entity.HardAndSoft;
import com.ramirezmatias.mgr.Security.Controller.Mensaje;
import com.ramirezmatias.mgr.Service.HaSService;
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
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendmgr-14d4e.web.app"})
@RequestMapping("/has")
public class HaSController {

    @Autowired
    HaSService hasService;

    @GetMapping("/lista")
    public ResponseEntity<List<HardAndSoft>> list() {
        List<HardAndSoft> list = hasService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHaS dtoHas) {
        if (StringUtils.isBlank(dtoHas.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (hasService.existsByNombre(dtoHas.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);
        }
        HardAndSoft has = new HardAndSoft(dtoHas.getNombre(), dtoHas.getValor());
        hasService.save(has);

        return new ResponseEntity(new Mensaje("Skill cargada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHaS dtoHas) {
        if (!hasService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        if (hasService.existsByNombre(dtoHas.getNombre()) && hasService.getByNombre(dtoHas.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoHas.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        HardAndSoft has = hasService.getOne(id).get();
        has.setNombre(dtoHas.getNombre());
        has.setValor(dtoHas.getValor());

        hasService.save(has);
        return new ResponseEntity(new Mensaje("Skill actualizada!"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!hasService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        hasService.delete(id);

        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<HardAndSoft> getById(@PathVariable("id") int id) {
        if (!hasService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Inexistente"), HttpStatus.NOT_FOUND);
        }
        HardAndSoft has = hasService.getOne(id).get();
        return new ResponseEntity(has, HttpStatus.OK);
    }
}
