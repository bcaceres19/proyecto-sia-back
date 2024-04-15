package com.gov.project.sia.utils.enums;

public enum EstadoTipoProductoEnum {

    H("HABILITADO"),
    I("INHABILITADO");

    private final String descripcion;

    EstadoTipoProductoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
