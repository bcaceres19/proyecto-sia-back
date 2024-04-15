package com.gov.project.sia.dto;

import lombok.Data;

import java.util.List;

@Data
public class RespuestaGeneralDto<T> {

    private Boolean status;

    private List<T> listaData;

    private Object data;

    private String mensaje;

}
