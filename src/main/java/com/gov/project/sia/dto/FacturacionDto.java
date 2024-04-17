package com.gov.project.sia.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class FacturacionDto {

    private String codigoPedido;

    private Long cantidadElementos;

    private Double total;

    private LocalDate fechaVenta;

    private LocalDate fechaInicioPedido;

}
