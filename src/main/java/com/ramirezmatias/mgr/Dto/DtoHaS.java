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
public class DtoHaS {
    @NotBlank
    private String nombre;
    @NotBlank
    private int valor;

    public DtoHaS() {
    }

    public DtoHaS(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
