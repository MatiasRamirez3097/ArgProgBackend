/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Service;

import com.ramirezmatias.mgr.Entity.Educacion;
import com.ramirezmatias.mgr.Repository.EduRepository;
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
public class EduService {
    @Autowired
    EduRepository eduRepository;
    
    public List<Educacion> list(){
        return eduRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return eduRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return eduRepository.findByNombreEdu(nombreEdu);
    }
    
    public void save(Educacion edu){
        eduRepository.save(edu);
    }
    
    public void delete(int id){
        eduRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return eduRepository.existsById(id);
    }
    
    public boolean existsByNombreEdu(String nombreEdu){
        return eduRepository.existsByNombreEdu(nombreEdu);
    }
}
