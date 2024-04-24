package com.gov.project.sia.service.output;

import com.gov.project.sia.dto.FacturacionDto;
import com.gov.project.sia.dto.RespuestaPedidoDto;

import java.util.List;

public interface IConsultaPedidoService {

    List<RespuestaPedidoDto> buscarPedidosEstadoPendientes();

    List<FacturacionDto> buscarPedidosCompletadosUsuario(Integer idUsuario, String tipo);

}
