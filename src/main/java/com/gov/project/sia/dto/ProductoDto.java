package com.gov.project.sia.dto;


import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ProductoDto {

    private String codigoProducto;

    private Double precioProducto;

    private LocalDate fechaVencimientoProducto;

    private EstadoProductoEnum estadoProducto;

    private InventarioDto idInventarioFk;

    private Integer posicionInsercion;


    private Integer idUsuarioInsercion;

}