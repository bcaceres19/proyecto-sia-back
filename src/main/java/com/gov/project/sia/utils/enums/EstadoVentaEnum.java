package com.gov.project.sia.utils.enums;

public enum EstadoVentaEnum {

    A("ACEPTADO"),
    P("PENDIENTE"),
    T("PENDIENTE_PEDIDO"),
    V("VENCIDO"),
    R("RECHAZADO");

    private final String descripcion;

    EstadoVentaEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
