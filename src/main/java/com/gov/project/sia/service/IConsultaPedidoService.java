package com.gov.project.sia.service;

import com.gov.project.sia.dto.PedidoDto;
import com.gov.project.sia.dto.RespuestaPedidoDto;

import java.util.List;

public interface IConsultaPedidoService {

    List<RespuestaPedidoDto> buscarPedidosEstadoPendientes();

}
