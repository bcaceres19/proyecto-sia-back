package com.gov.project.sia.dto;

import lombok.Data;

@Data
public class NodoPilaDto {

    private int datoOrdenamiento;
    private Object objeto;
    private NodoPilaDto siguiente;

    public NodoPilaDto(int valor, Object objeto){
        this.datoOrdenamiento=valor;
        this.objeto = objeto;
        this.siguiente=null;
    }

}
