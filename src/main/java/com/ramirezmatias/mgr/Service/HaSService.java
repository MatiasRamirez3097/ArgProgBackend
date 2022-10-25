/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Service;

import com.ramirezmatias.mgr.Entity.HardAndSoft;
import com.ramirezmatias.mgr.Repository.HaSRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Transactional
@Service
public class HaSService {
    @Autowired
    HaSRepository hasrepository;
    
    public List<HardAndSoft> list(){
        return hasrepository.findAll();
    }
    
    public Optional<HardAndSoft> getOne(int id){
        return hasrepository.findById(id);
    }
    
    public Optional<HardAndSoft> getByNombre(String nombre){
        return hasrepository.findByNombre(nombre);
    }
    
    public void save(HardAndSoft skill){
        hasrepository.save(skill);
    }
    
    public void delete(int id){
        hasrepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return hasrepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return hasrepository.existsByNombre(nombre);
    }
}
