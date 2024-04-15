package com.gov.project.sia.utils.enums;

public enum EstadoProductoEnum {

    F("FRESCO"),
    V("VENCIDO"),
    P("POR_VENCER");

    private final String descripcion;

    EstadoProductoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
