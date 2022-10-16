/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirezmatias.mgr.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author matia
 */
public class DtoExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descExp;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, String descExp) {
        this.nombreExp = nombreExp;
        this.descExp = descExp;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescExp() {
        return descExp;
    }

    public void setDescExp(String descExp) {
        this.descExp = descExp;
    }
   
    
}
