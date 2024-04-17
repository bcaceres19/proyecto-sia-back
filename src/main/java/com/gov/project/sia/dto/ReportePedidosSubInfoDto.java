package com.gov.project.sia.dto;

import lombok.Data;

@Data
public class ReportePedidosSubInfoDto {

    private String codigoProducto;

    private String valorProducto;

    private String fechaVencimientoProducto;

    private String codigoPedido;

    private String fechaPedido;

    private String fechaVenta;

}
