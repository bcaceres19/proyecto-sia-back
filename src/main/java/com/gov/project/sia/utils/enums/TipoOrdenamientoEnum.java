package com.gov.project.sia.utils.enums;

import lombok.Getter;

@Getter
public enum TipoOrdenamientoEnum {

    INORDEN(1),
    POST_ORDEN(2),
    PRE_ORDEN(3);

    private final Integer opcion;

    TipoOrdenamientoEnum(Integer opcion) {
        this.opcion = opcion;
    }


}
