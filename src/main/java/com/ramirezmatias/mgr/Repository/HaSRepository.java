/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ramirezmatias.mgr.Repository;

import com.ramirezmatias.mgr.Entity.HardAndSoft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author matia
 */
@Repository
public interface HaSRepository extends JpaRepository<HardAndSoft, Integer>{
    Optional<HardAndSoft> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
