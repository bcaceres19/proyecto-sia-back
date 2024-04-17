package com.gov.project.sia.service;

import com.gov.project.sia.dto.PedidoDto;
import com.gov.project.sia.dto.VentaDto;

import java.util.List;

public interface IRegistrarPedidoService {

    Boolean aceptarPedido(PedidoDto pedidos);

    Boolean rechazarPedido(PedidoDto pedido);

    void iniciarPedido(VentaDto venta);

}
