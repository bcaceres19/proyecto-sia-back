package com.gov.project.sia.dto;

import lombok.Data;

@Data
public class ProductoRespuestaDto {

    private Long indice;
    private String codigoProducto;
    private String fechaVencimiento;
    private String tipoProducto;
    private Double precioProducto;
    private String estadoProducto;

}
