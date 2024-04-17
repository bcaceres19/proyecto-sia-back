package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.*;
import com.gov.project.sia.entity.PedidoEntity;
import com.gov.project.sia.entity.VentaProductoEntity;
import com.gov.project.sia.utils.helper.Funciones;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.reactor.ReactorProperties;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoEntity pedidoDtoToPedidoEntity(PedidoDto pedidoDto);
    PedidoDto entityTODto(PedidoEntity pedidoDto);

    default RespuestaPedidoDto objectToRespuestaPedidoDto(Object object){
        return (RespuestaPedidoDto) object;
    }

    default FacturacionDto objectToFacturacionDto(Object[] object){
        FacturacionDto facturacion = new FacturacionDto();
        facturacion.setCodigoPedido(Funciones.checkType(object[0], String.class));
        facturacion.setCantidadElementos(Funciones.checkType(object[1], Long.class));
        facturacion.setTotal(Funciones.checkType(object[2], Double.class));
        facturacion.setFechaVenta(Funciones.checkType(object[3], LocalDate.class));
        facturacion.setFechaInicioPedido(Funciones.checkType(object[4], LocalDate.class));
        return facturacion;
    }

    default ReportePedidosDto objectToReportePedidoDto(Object[] objects){
        ReportePedidosDto reporte = new ReportePedidosDto();
        reporte.setNombreUsuario(Funciones.checkType(objects[0], String.class));
        reporte.setEmail(Funciones.checkType(objects[1], String.class));
        reporte.setTelefono(Funciones.checkType(objects[2], String.class));
        reporte.setCantidadProductos(Funciones.checkType(objects[3], String.class));
        reporte.setTotalCompra(Funciones.checkType(objects[4], String.class));
        return reporte;
    }

    default ReportePedidosSubInfoDto objectToReportePedidosSubInfoDto(Object[] objects){
        ReportePedidosSubInfoDto subInfo = new ReportePedidosSubInfoDto();
        subInfo.setCodigoProducto(Funciones.checkType(objects[0], String.class));
        subInfo.setValorProducto(Funciones.checkType(objects[1], String.class));
        subInfo.setFechaVencimientoProducto(Funciones.checkType(objects[2], String.class));
        subInfo.setCodigoPedido(Funciones.checkType(objects[3], String.class));
        subInfo.setFechaPedido(Funciones.checkType(objects[4], String.class));
        subInfo.setFechaVenta(Funciones.checkType(objects[5], String.class));
        return subInfo;
    }

}
