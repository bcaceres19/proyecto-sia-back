package com.gov.project.sia.utils.enums;

public enum EstadoProductoEnum {

    FRESCO("F"),
    VENCIDO("V"),
    POR_VENCER("P");

    private final String descripcion;

    EstadoProductoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
