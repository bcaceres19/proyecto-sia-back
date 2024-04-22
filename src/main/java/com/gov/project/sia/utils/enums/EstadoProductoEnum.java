package com.gov.project.sia.utils.enums;

public enum EstadoProductoEnum {

    F("FRESCO","Fresco"),
    V("VENCIDO","Vencido"),
    PV("POR_VENCER","Por Vencer");

    private final String textoSalida;

    private final String descripcion;

    EstadoProductoEnum(String descripcion, String textoSalida) {
        this.textoSalida = textoSalida;
        this.descripcion = descripcion;
    }

    public String getTextoSalida(){
        return this.textoSalida;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
