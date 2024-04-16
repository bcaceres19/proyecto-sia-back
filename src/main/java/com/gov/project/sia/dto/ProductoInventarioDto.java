package com.gov.project.sia.dto;

import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductoInventarioDto {

    private String codigoProducto;

    private LocalDate fechaVencimientoProducto;

    private Double precioProducto;

    private EstadoProductoEnum estadoProducto;

    private String nombreProductoInventario;

    private String stockProductoInventario;

    private Double precioProductoInventario;

}
