package com.gov.project.sia.utils.enums;

public enum EstadoRolEnum {

    H("HABILITADO"),
    I("INHABILITADO");

    private final String descripcion;

    EstadoRolEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
