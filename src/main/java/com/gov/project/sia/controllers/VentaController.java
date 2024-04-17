package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.*;
import com.gov.project.sia.service.IAccionesProductoService;
import com.gov.project.sia.service.IConsultaVentaProductoService;
import com.gov.project.sia.service.IRegistrarVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
@RequiredArgsConstructor
public class VentaController {
    private final IConsultaVentaProductoService iConsultaVentaProductoService;
    private final IRegistrarVentaService iRegistrarVentaService;
    private final IAccionesProductoService iAccionesProductoService;
   @GetMapping("/consultar-sin-confirmar")
    public ResponseEntity<RespuestaGeneralDto> consultarVentasSinConfirmar(@RequestParam("idUsuario") Integer idUsuario){
       RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
       respuesta.setStatus(Boolean.TRUE);
       respuesta.setData(iConsultaVentaProductoService.consultaVentaUsuarioSinConfirmar(idUsuario));
       respuesta.setMensaje("Se consulto correctamente");
       return  ResponseEntity.ok(respuesta);
    }

    @GetMapping("/consultar-confirmado")
    public ResponseEntity<VentaProductoRespuestaDto> consultarVentasConfirmadas(@RequestParam("idUsuario") Integer idUsuario){
        return  ResponseEntity.ok(iConsultaVentaProductoService.consultaVentaUsuarioConfirmar(idUsuario));
    }

    @PostMapping("/crear-venta-sin-pedido")
    public ResponseEntity<Boolean> crearVenta(@RequestBody ProductoDto productoDto ){
        iRegistrarVentaService.crearVenta(productoDto);
        return  ResponseEntity.ok(true);
    }

    @PostMapping("/crear-venta-con-pedido")
    public ResponseEntity<Boolean> crearVentaConPedido(@RequestBody VentaDto ventaConfirmada){
        iRegistrarVentaService.realizarVentaPedidoConfirmado(ventaConfirmada);
        return  ResponseEntity.ok(true);
    }
    @PostMapping("/eliminar-venta")
    public ResponseEntity<Boolean> eliminarVenta(@RequestParam Integer idVenta){
        iRegistrarVentaService.eliminarVenta(idVenta);
        return  ResponseEntity.ok(true);
    }

    @PostMapping("/rechazar-venta")
    public ResponseEntity<Boolean> rechazarVenta(@RequestBody List<VentaDto> ventaDtos){
        iRegistrarVentaService.realizarVentaPedidoRechazado(ventaDtos);
        return  ResponseEntity.ok(true);
    }

    @PostMapping("/eliminar-producto-venta")
    public ResponseEntity<Boolean> eliminarProductoVenta(@RequestParam Integer idVentaProducto){
        iAccionesProductoService.eliminarProductoVenta(idVentaProducto);
        return  ResponseEntity.ok(true);
    }
}
