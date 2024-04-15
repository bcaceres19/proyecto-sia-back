package com.gov.project.sia.controller;

import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaInDto;
import com.gov.project.sia.dto.VentaProductoDto;
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

   @GetMapping("/consultar-sin-confirmar")
    public ResponseEntity<List<VentaProductoDto>> consultarVentasSinConfirmar(@RequestParam("idUsuario") Integer idUsuario){
        return  ResponseEntity.ok(iConsultaVentaProductoService.consultaVentaUsuarioSinConfirmar(idUsuario));
    }

    @GetMapping("/consultar-confirmado")
    public ResponseEntity<List<VentaProductoDto>> consultarVentasConfirmadas(@RequestParam("idUsuario") Integer idUsuario){
        return  ResponseEntity.ok(iConsultaVentaProductoService.consultaVentaUsuarioConfirmar(idUsuario));
    }

    @PostMapping("/crear-venta-sin-pedido")
    public ResponseEntity<Boolean> crearVenta(@RequestBody VentaInDto ventaInDto){
        iRegistrarVentaService.crearVenta(ventaInDto);
        return  ResponseEntity.ok(true);
    }

    @PostMapping("/crear-venta-con-pedido")
    public ResponseEntity<Boolean> crearVentaConPedido(@RequestBody List<VentaDto> ventaDtos){
        iRegistrarVentaService.realizarVentaPedidoConfirmado(ventaDtos);
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

}
