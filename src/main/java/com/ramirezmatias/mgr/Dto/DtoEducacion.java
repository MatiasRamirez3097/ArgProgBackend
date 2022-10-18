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
public class DtoEducacion {
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descEdu;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEdu, String descEdu) {
        this.nombreEdu = nombreEdu;
        this.descEdu = descEdu;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescEdu() {
        return descEdu;
    }

    public void setDescEdu(String descEdu) {
        this.descEdu = descEdu;
    }
}
