package com.gov.project.sia.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReportePedidosDto {

    private String nombreUsuario;

    private String email;

    private String telefono;

    private List<ReportePedidosSubInfoDto> dataSource;

    private String totalCompra;

    private String cantidadProductos;

}
