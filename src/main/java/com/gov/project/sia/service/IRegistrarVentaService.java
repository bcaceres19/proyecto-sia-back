package com.gov.project.sia.service;

import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaInDto;

import java.util.List;

public interface IRegistrarVentaService {

    public void crearVenta(ProductoDto producto);

    void eliminarVenta(Integer idVenta);

    void realizarVentaPedidoConfirmado(VentaDto ventaConfirmada);

    void realizarVentaPedidoRechazado(List<VentaDto> ventasRechazar);

}
