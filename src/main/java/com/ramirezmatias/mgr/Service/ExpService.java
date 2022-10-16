/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Service;

import com.ramirezmatias.mgr.Entity.Experiencia;
import com.ramirezmatias.mgr.Repository.ExpRepository;
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
public class ExpService {
    @Autowired
    ExpRepository expRepo;
    
    public List<Experiencia> list(){
        return expRepo.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return expRepo.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return expRepo.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia exp){
        expRepo.save(exp);
    }
    
    public void delete(int id){
        expRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return expRepo.existsById(id);
    }
    
    public boolean existsByNombreExp(String nombreExp){
        return expRepo.existsByNombreExp(nombreExp);
    }
}
