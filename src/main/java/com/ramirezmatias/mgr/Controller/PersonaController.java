/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Controller;

import com.ramirezmatias.mgr.Entity.Persona;
import com.ramirezmatias.mgr.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matia
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/get")
    public List<Persona> getPersona()
    {
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/new")
    public String createPersona(@RequestBody Persona p)
    {
        ipersonaService.savePersona(p);
        return "Persona creada correctamente";
    }
    
    @DeleteMapping("/personas/delete/{id}")
    public String deletePersona(@PathVariable Long id)
    {
        ipersonaService.deletePersona(id);
        return "Persona eliminada";
    }
    
    @PutMapping("/personas/edit/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg)
    {
        Persona p = ipersonaService.findPersona(id);
        
        p.setNombre(nuevoNombre);
        p.setApellido(nuevoApellido);
        p.setImg(nuevoImg);
        
        ipersonaService.savePersona(p);
        return p;
    }
    
    @GetMapping("/personas/getprofile")
    public Persona findPersona()
    {
        return ipersonaService.findPersona((long)1);
    }
}
