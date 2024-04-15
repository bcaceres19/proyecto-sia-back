package com.gov.project.sia.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductoRespuestaDto {

    private String codigoProducto;
    private String estadoProducto;
    private Double precioProducto;
   private Double precioProductoInventario;
    private LocalDate fechaVencimientoProducto;
    private String nombreProducto;
    private String imagenProducto;

}
