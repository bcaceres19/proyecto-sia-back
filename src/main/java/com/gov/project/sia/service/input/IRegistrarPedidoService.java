package com.gov.project.sia.service.input;

import com.gov.project.sia.dto.PedidoDto;
import com.gov.project.sia.dto.VentaDto;

public interface IRegistrarPedidoService {

    Boolean aceptarPedido(PedidoDto pedidos);

    Boolean rechazarPedido(PedidoDto pedido);

    void iniciarPedido(VentaDto venta);

}
