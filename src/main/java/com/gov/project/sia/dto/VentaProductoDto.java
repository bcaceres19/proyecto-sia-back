package com.gov.project.sia.dto;

import com.gov.project.sia.entity.ProductoEntity;
import com.gov.project.sia.entity.VentaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class VentaProductoDto {

    private Integer idVentaProducto;

    private ProductoDto idProductoFk;


    private VentaDto idVentaFk;


    public VentaProductoDto(Integer idVentaProducto,VentaEntity ventaEntity, ProductoEntity productoEntity ) {
        VentaDto ventaDto = new VentaDto();
        ventaDto.setIdVenta(ventaEntity.getIdVenta());
        ventaDto.setPrecioTotalVenta(ventaEntity.getPrecioTotalVenta());
        ventaDto.setFechaVenta(ventaEntity.getFechaVenta());
        ventaDto.setEstadoVenta(ventaEntity.getEstadoVenta());
        ventaDto.setCantidadVenta(ventaEntity.getCantidadVenta());
        ProductoDto productoDto = new ProductoDto();
        productoDto.setCodigoProducto(productoEntity.getCodigoProducto());
        productoDto.setPrecioProducto(productoEntity.getPrecioProducto());
        productoDto.setEstadoProducto(productoEntity.getEstadoProducto());

        this.idVentaProducto = idVentaProducto;
        this.idVentaFk = ventaDto;
        this.idProductoFk = productoDto;

    }

}