package com.gov.project.sia.controller;


import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.dto.RespuestaPedidoDto;
import com.gov.project.sia.service.IConsultaPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final IConsultaPedidoService iConsultaPedidoService;

    @GetMapping("/consultar-pedidos-pendientes")
    public ResponseEntity<RespuestaGeneralDto> consultarVentasSinConfirmar(){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultaPedidoService.buscarPedidosEstadoPendientes());
        respuesta.setMensaje("Se consulto correctamente");
        return  ResponseEntity.ok(respuesta);
    }

}
