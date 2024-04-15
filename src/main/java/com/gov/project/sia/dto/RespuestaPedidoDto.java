package com.gov.project.sia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RespuestaPedidoDto {

    private String codigoPedido;

    private LocalDate fechaInicioPedido;

    private LocalDate fechaVencimientoPedido;

    private Short cantidadProductosVenta;

    private Double valorTotal;

    private List<ProductoDto> productos;

    public RespuestaPedidoDto(String codigoPedido,
                              LocalDate fechaInicioPedido,
                              LocalDate fechaVencimientoPedido,
                              Short cantidadProductosVenta,
                              Double valorTotal) {
        this.codigoPedido = codigoPedido;
        this.fechaInicioPedido = fechaInicioPedido;
        this.fechaVencimientoPedido = fechaVencimientoPedido;
        this.cantidadProductosVenta = cantidadProductosVenta;
        this.valorTotal = valorTotal;
    }
}
