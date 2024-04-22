package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.InventarioRespuestaDto;
import com.gov.project.sia.dto.TipoProductoDto;
import com.gov.project.sia.entity.InventarioEntity;
import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import com.gov.project.sia.utils.enums.EstadoTipoProductoEnum;
import com.gov.project.sia.utils.helper.Funciones;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface InventarioMapper {

    InventarioDto inventarioEntityToInventarioDto(InventarioEntity inventarioEntity);

    InventarioEntity inventarioDtoToInventarioEntity(InventarioDto inventarioDto);

    default InventarioRespuestaDto objectListToInventarioRespuestaDto(Object[] object){
        InventarioRespuestaDto inventarioRes = new InventarioRespuestaDto();
        inventarioRes.setIdInventario(Funciones.checkType(object[0], Integer.class));
        inventarioRes.setNombreProducto(Funciones.checkType(object[1], String.class));
        inventarioRes.setImagenProducto(Funciones.checkType(object[2], String.class));
        return inventarioRes;
    }
    default void objectListToDetalleInventario(Object[] object, InventarioRespuestaDto inventarioRes){
        inventarioRes.setCodigoProducto(Funciones.checkType(object[0], String.class));
        inventarioRes.setEstadoProducto(Funciones.checkType(object[1], EstadoProductoEnum.class).getTextoSalida());
        inventarioRes.setPrecioProducto(Funciones.checkType(object[2], Double.class));
        inventarioRes.setFechaVencimientoProducto(Funciones.checkType(object[3], LocalDate.class));
    }

    default  InventarioRespuestaDto objectToInventarioRespuestaDto(Object object){
        return (InventarioRespuestaDto) object;
    }


}
