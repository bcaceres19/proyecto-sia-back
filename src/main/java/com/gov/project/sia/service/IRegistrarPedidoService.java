package com.gov.project.sia.service;

import com.gov.project.sia.dto.PedidoDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaInDto;

import java.util.List;

public interface IRegistrarPedidoService {

    void aceptarPedido(List<PedidoDto> codigosPedido);

    void iniciarPedido(List<VentaDto> ventas);

}
