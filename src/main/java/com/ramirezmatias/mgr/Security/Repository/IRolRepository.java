/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ramirezmatias.mgr.Security.Repository;

import com.ramirezmatias.mgr.Securiy.Entity.Rol;
import com.ramirezmatias.mgr.Securiy.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author matia
 */
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional <Rol> findByRolNombre(RolNombre rolNombre);
}
