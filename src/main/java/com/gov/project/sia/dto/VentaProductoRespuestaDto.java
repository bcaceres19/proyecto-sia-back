package com.gov.project.sia.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VentaProductoRespuestaDto {

    private VentaDto venta;

    private List<ProductoDto> productos;

    public VentaProductoRespuestaDto() {
        this.productos = new ArrayList<>();
    }

    public void add(ProductoDto producto){
        productos.add(producto);
    }
}
