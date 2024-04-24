package com.gov.project.sia.service.input;

import com.gov.project.sia.dto.PedidoDto;
import com.gov.project.sia.dto.VentaDto;

public interface IAccionesPedidoService {

    Boolean aceptarPedido(PedidoDto pedidos);

    Boolean rechazarPedido(PedidoDto pedido);

    void iniciarPedido(VentaDto venta);

    void cambiarEstado(String codigoPedido, String estado);
}
