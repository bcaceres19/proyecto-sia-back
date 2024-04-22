package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.*;
import com.gov.project.sia.entity.ProductoEntity;
import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import com.gov.project.sia.utils.helper.Funciones;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDto productoEntityToProductoDto(ProductoEntity productoEntity);

    default ProductoDto objectToProducto(Object[] objeto){
        ProductoDto productoDto = new ProductoDto();
        productoDto.setCodigoProducto(Funciones.checkType(objeto[0], String.class));
        productoDto.setFechaVencimientoProducto(Funciones.checkType(objeto[1], LocalDate.class));
        productoDto.setPrecioProducto(Funciones.checkType(objeto[2], Double.class));
        productoDto.setEstadoProducto(Funciones.checkType(objeto[3], EstadoProductoEnum.class));
        return productoDto;
    }

    default ProductoRespuestaDto objetctToProductoRespuesta(Object[] objeto){
        ProductoRespuestaDto productoRespuestaDto = new ProductoRespuestaDto();
        productoRespuestaDto.setCodigoProducto(Funciones.checkType(objeto[0], String.class));
        return productoRespuestaDto;
    }

    default ProductoRespuestaDto objectToInventarioDto(Object object){
        return (ProductoRespuestaDto) object;
    }


    default ProductoRespuestaDto objectToProductoRespuestaDto(Object[] objeto){
        ProductoRespuestaDto productoRespuestaDto = new ProductoRespuestaDto();
        productoRespuestaDto.setIndice(Funciones.checkType(objeto[0], Long.class));
        productoRespuestaDto.setCodigoProducto(Funciones.checkType(objeto[1], String.class));
        productoRespuestaDto.setFechaVencimiento(Funciones.checkType(objeto[2], String.class));
        productoRespuestaDto.setTipoProducto(Funciones.checkType(objeto[3], String.class));
        productoRespuestaDto.setPrecioProducto(Funciones.checkType(objeto[4], Double.class));
        productoRespuestaDto.setEstadoProducto(Funciones.checkType(objeto[5], EstadoProductoEnum.class).getTextoSalida());
        return productoRespuestaDto;
    }

    default ProductoInventarioDto objectToProductoInventario(Object[] objeto){
        ProductoInventarioDto productoInventarioDto = new ProductoInventarioDto();
        productoInventarioDto.setCodigoProducto(Funciones.checkType(objeto[0], String.class));
        productoInventarioDto.setFechaVencimientoProducto(Funciones.checkType(objeto[1], LocalDate.class));
        productoInventarioDto.setPrecioProducto(Funciones.checkType(objeto[2], Double.class));
        productoInventarioDto.setEstadoProducto(Funciones.checkType(objeto[3], EstadoProductoEnum.class));
        productoInventarioDto.setNombreProductoInventario(Funciones.checkType(objeto[4], String.class));
        productoInventarioDto.setStockProductoInventario(Funciones.checkType(objeto[5], String.class));
        productoInventarioDto.setPrecioProductoInventario(Funciones.checkType(objeto[6], Double.class));
        return productoInventarioDto;
    }

}
