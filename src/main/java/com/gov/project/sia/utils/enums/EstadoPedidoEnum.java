package com.gov.project.sia.utils.enums;

public enum EstadoPedidoEnum {

    ACEPTADO("A"),
    PENDIENTE("P"),
    VENCIDO("V"),
    RECHAZADO("R");

    private final String descripcion;

    EstadoPedidoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
