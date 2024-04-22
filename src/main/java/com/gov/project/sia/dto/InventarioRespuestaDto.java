package com.gov.project.sia.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class InventarioRespuestaDto {

    private String codigoProducto;
    private Integer idInventario;
    private String estadoProducto;
    private Double precioProducto;
    private LocalDate fechaVencimientoProducto;
    private String nombreProducto;
    private String imagenProducto;

    public InventarioRespuestaDto(Integer idInventario, String nombreProducto, String imagenProducto) {
        this.idInventario = idInventario;
        this.nombreProducto = nombreProducto;
        this.imagenProducto = imagenProducto;
    }
}
