package com.gov.project.sia.utils.enums;

public enum EstadoTipoProductoEnum {

    HABILITADO("H"),
    INHABILITADO("I");

    private final String descripcion;

    EstadoTipoProductoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
