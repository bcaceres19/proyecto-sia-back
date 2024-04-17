package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.entity.InventarioEntity;
import com.gov.project.sia.entity.VentaEntity;
import com.gov.project.sia.entity.VentaProductoEntity;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import com.gov.project.sia.utils.helper.Funciones;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VentaMapper {

    VentaEntity ventaDtoToVentaEntity(VentaDto ventaDto);

    VentaDto VentaEntityToVentaDto(VentaEntity ventaEntity);

    default VentaDto objectToVentaDto(Object[] object){
        VentaDto venta = new VentaDto();
        venta.setIdVenta(Funciones.checkType(object[0], Integer.class));
        venta.setCantidadVenta(Funciones.checkType(object[1], Short.class));
        venta.setPrecioTotalVenta(Funciones.checkType(object[2], Double.class));
        venta.setEstadoVenta(Funciones.checkType(object[3], EstadoVentaEnum.class));
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(Funciones.checkType(object[4], Integer.class));
        venta.setIdUsuarioFk(usuarioDto);
        return venta;
    }




}
