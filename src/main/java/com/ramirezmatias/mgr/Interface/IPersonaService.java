/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ramirezmatias.mgr.Interface;

import com.ramirezmatias.mgr.Entity.Persona;
import java.util.List;


/**
 *
 * @author matia
 */
public interface IPersonaService {
    public List<Persona> getPersona();
    
    public void savePersona(Persona p);

    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
