/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Service;

import com.ramirezmatias.mgr.Entity.Persona;
import com.ramirezmatias.mgr.Interface.IPersonaService;
import com.ramirezmatias.mgr.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;
            
    @Override
    public List<Persona> getPersona() {
        List<Persona> p = ipersonaRepository.findAll();
        return p;
    }

    @Override
    public void savePersona(Persona p) {
        ipersonaRepository.save(p);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona p = ipersonaRepository.findById(id).orElse(null);
        return p;
    }
    
}
