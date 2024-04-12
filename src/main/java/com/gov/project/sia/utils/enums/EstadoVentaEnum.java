package com.gov.project.sia.utils.enums;

public enum EstadoVentaEnum {

    ACEPTADO("A"),
    PENDIENTE("P"),
    VENCIDO("V"),
    RECHAZADO("R");

    private final String descripcion;

    EstadoVentaEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
