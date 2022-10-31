/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Service;

import com.ramirezmatias.mgr.Entity.Persona;
import com.ramirezmatias.mgr.Repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
@Transactional
public class PersonaService {
    @Autowired 
    PersonaRepository personaRepository;
    
    public List<Persona> list(){
        return personaRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return personaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombreExp(String nombre){
        return personaRepository.findByNombre(nombre);
    }
    
    public void save(Persona persona){
        personaRepository.save(persona);
    }
    
    public void delete(int id){
        personaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return personaRepository.existsByNombre(nombre);
    }
}
