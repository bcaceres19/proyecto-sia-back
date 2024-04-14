package com.gov.project.sia.service;

import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaInDto;

import java.util.List;

public interface IRegistrarVentaService {

    void crearVenta(VentaInDto ventaEntrada);

    void eliminarVenta(Integer idVenta);

    void realizarVentaPedidoConfirmado(List<VentaDto> ventasConfirmar);

    void realizarVentaPedidoRechazado(List<VentaDto> ventasRechazar);

}
