package com.gov.project.sia.service.input;

import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.VentaDto;

import java.util.List;

public interface IRegistrarVentaService {

     void crearVenta(ProductoDto producto);

    void eliminarVenta(Integer idVenta);

    void realizarVentaPedidoConfirmado(VentaDto ventaConfirmada);

    void realizarVentaPedidoRechazado(List<VentaDto> ventasRechazar);

}
