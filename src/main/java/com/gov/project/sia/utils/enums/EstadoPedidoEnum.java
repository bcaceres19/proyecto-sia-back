package com.gov.project.sia.utils.enums;

public enum EstadoPedidoEnum {

    A("ACEPTADO"),
    P("PENDIENTE"),
    V("VENCIDO"),
    R("RECHAZADO"),
    EU("ELIMINADO_USUARIO");

    private final String descripcion;

    EstadoPedidoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
