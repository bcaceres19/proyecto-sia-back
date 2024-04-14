package com.gov.project.sia.dto;

import lombok.Data;

import java.util.List;

@Data
public class VentaInDto {

    private Double precioTotal;
    private Integer cantidadVenta;
    private List<ProductoDto> productoDto;
    private UsuarioDto usuarioDto;

}
