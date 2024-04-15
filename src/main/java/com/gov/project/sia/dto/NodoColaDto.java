package com.gov.project.sia.dto;

import lombok.Data;

@Data
public class NodoColaDto {

    private int dato;
    private Object objeto;
    private NodoColaDto siguiente;
    public NodoColaDto(int d, Object objeto){
        this.dato = d;
        this.objeto = objeto;
        this.siguiente= null;
    }

}
