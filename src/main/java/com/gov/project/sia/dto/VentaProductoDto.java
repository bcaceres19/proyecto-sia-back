package com.gov.project.sia.dto;

import com.gov.project.sia.entity.ProductoEntity;
import com.gov.project.sia.entity.VentaEntity;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class VentaProductoDto {


    private ProductoDto idProductoFk;


    private VentaDto idVentaFk;


    public VentaProductoDto(VentaEntity ventaEntity, ProductoEntity productoEntity ) {
        VentaDto ventaDto = new VentaDto();
        ventaDto.setIdVenta(ventaEntity.getIdVenta());
        ventaDto.setPrecioTotalVenta(ventaEntity.getPrecioTotalVenta());
        ventaDto.setFechaVenta(ventaEntity.getFechaVenta());
        ventaDto.setEstadoVenta(ventaEntity.getEstadoVenta());
        ProductoDto productoDto = new ProductoDto();
        productoDto.setCodigoProducto(productoEntity.getCodigoProducto());
        productoDto.setEstadoProducto(productoEntity.getEstadoProducto());

        this.idVentaFk = ventaDto;
        this.idProductoFk = productoDto;

    }

}