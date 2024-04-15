package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.ProductoRespuestaDto;
import com.gov.project.sia.entity.InventarioEntity;
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
        productoRespuestaDto.setEstadoProducto(Funciones.checkType(objeto[1], String.class));
        productoRespuestaDto.setPrecioProductoInventario(Funciones.checkType(objeto[2], Double.class));
        productoRespuestaDto.setPrecioProducto(Funciones.checkType(objeto[3], Double.class));
        productoRespuestaDto.setFechaVencimientoProducto(LocalDate.parse(objeto[4].toString()));
        productoRespuestaDto.setNombreProducto(Funciones.checkType(objeto[5], String.class));
        productoRespuestaDto.setImagenProducto(Funciones.checkType(objeto[6], String.class));
        return productoRespuestaDto;
    }

}
