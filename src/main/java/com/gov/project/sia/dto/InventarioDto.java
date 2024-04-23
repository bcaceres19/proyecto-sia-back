package com.gov.project.sia.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InventarioDto {

    private Integer idInventario;

    private Double precioProductoInventario;

    private Integer stockProductoInventario;

    private String nombreProductoInventario;

    private TipoProductoDto idTipoProductoFk;

    private String urlImagenProducto;

    private Integer porcentajeAumentoPrecio;

    private LocalDate fechaVencimiento;

}