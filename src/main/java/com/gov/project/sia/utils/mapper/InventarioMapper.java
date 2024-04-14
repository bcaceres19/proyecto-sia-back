package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.TipoProductoDto;
import com.gov.project.sia.entity.InventarioEntity;
import com.gov.project.sia.utils.helper.Funciones;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventarioMapper {

    InventarioDto inventarioEntityToInventarioDto(InventarioEntity inventarioEntity);

    InventarioEntity inventarioDtoToInventarioEntity(InventarioDto inventarioDto);

    default InventarioDto objectToInventarioDto(Object[] objeto){
        TipoProductoDto tipoProductoDto = new TipoProductoDto();
        tipoProductoDto.setNombreTipoProducto(Funciones.checkType(objeto[4], String.class));
        InventarioDto inventarioDto = new InventarioDto();
        inventarioDto.setIdInventario(Funciones.checkType(objeto[0], Integer.class));
        inventarioDto.setPrecioProductoInventario(Funciones.checkType(objeto[1], Double.class));
        inventarioDto.setStockProductoInventario(Funciones.checkType(objeto[2], Integer.class));
        inventarioDto.setNombreProductoInventario(Funciones.checkType(objeto[3], String.class));
        inventarioDto.setIdTipoProductoFk(tipoProductoDto);
        return inventarioDto;
    }

    default InventarioDto objectToInventarioDto(Object object){
        return (InventarioDto) object;
    }

}
