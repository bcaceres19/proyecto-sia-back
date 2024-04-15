package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.entity.VentaEntity;
import com.gov.project.sia.entity.VentaProductoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaProductoMapper {

    VentaProductoEntity ventaProductoDtoToVentaProductoEntity(VentaProductoDto ventaProductoDto);

    VentaProductoDto ventaProductoEntityToventaProductoDto(VentaProductoEntity ventaProductoEntity);


    default VentaProductoDto objectToVentaDto(Object object){
        return (VentaProductoDto) object;
    }
}
