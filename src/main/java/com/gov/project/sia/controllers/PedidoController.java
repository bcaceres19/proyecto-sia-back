package com.gov.project.sia.controllers;


import com.gov.project.sia.dto.PedidoDto;
import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.service.output.IConsultaPedidoService;
import com.gov.project.sia.service.input.IGenerarReporteService;
import com.gov.project.sia.service.input.IRegistrarPedidoService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final IConsultaPedidoService iConsultaPedidoService;

    private final IGenerarReporteService iGenerarReporteService;

    private final IRegistrarPedidoService iRegistrarPedidoService;

    @GetMapping("/consultar-pedidos-pendientes")
    public ResponseEntity<RespuestaGeneralDto> consultarVentasSinConfirmar(){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultaPedidoService.buscarPedidosEstadoPendientes());
        respuesta.setMensaje("Se consulto correctamente");
        return  ResponseEntity.ok(respuesta);
    }

    @GetMapping("/consultar-pedidos-facturacion")
    public ResponseEntity<RespuestaGeneralDto> consultarPedidosFacturacion(@RequestParam Integer idUsuario){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultaPedidoService.buscarPedidosCompletadosUsuario(idUsuario));
        respuesta.setMensaje("Se consulto correctamente");
        return  ResponseEntity.ok(respuesta);
    }

    @GetMapping("/generar-reporte")
    public ResponseEntity<RespuestaGeneralDto> generarReporte(@RequestParam String codigoPedido) throws JRException, FileNotFoundException {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setData(iGenerarReporteService.generarReportePedidos(codigoPedido));
        respuesta.setMensaje("Se consulto correctamente");
        return  ResponseEntity.ok(respuesta);
    }

    @PostMapping("/aceptar-pedido")
    public ResponseEntity<RespuestaGeneralDto> aceptarPedido(@RequestBody PedidoDto pedidoIn) throws JRException, FileNotFoundException {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setData(iRegistrarPedidoService.aceptarPedido(pedidoIn));
        respuesta.setMensaje("Se registraron correctamente");
        return  ResponseEntity.ok(respuesta);
    }

    @PostMapping("/rechazar-pedido")
    public ResponseEntity<RespuestaGeneralDto> rechazarPedido(@RequestBody PedidoDto pedidoIn) throws JRException, FileNotFoundException {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setData(iRegistrarPedidoService.rechazarPedido(pedidoIn));
        respuesta.setMensaje("Se registraron correctamente");
        return  ResponseEntity.ok(respuesta);
    }
}
