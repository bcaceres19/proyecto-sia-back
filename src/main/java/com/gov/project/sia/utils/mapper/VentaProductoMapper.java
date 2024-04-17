package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.dto.VentaProductoRespuestaDto;
import com.gov.project.sia.entity.VentaEntity;
import com.gov.project.sia.entity.VentaProductoEntity;
import com.gov.project.sia.utils.helper.Funciones;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaProductoMapper {

    VentaProductoEntity ventaProductoDtoToVentaProductoEntity(VentaProductoDto ventaProductoDto);

    VentaProductoDto ventaProductoEntityToventaProductoDto(VentaProductoEntity ventaProductoEntity);


    default VentaProductoDto objectToVentaDto(Object object){
        return (VentaProductoDto) object;
    }

    default void objectToVentaProductoRespuestaDto(Object object, VentaProductoRespuestaDto ventaProductoRespuestaDto){
        VentaProductoDto ventaProductoDto = (VentaProductoDto) object;
        ventaProductoRespuestaDto.setVenta(ventaProductoDto.getIdVentaFk());
        ventaProductoDto.getIdProductoFk().setPosicionInsercion(ventaProductoDto.getIdVentaProducto());
        ventaProductoRespuestaDto.add(ventaProductoDto.getIdProductoFk());
    }



}
