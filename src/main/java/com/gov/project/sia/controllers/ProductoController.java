package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.service.input.IAccionesProductoService;
import com.gov.project.sia.service.output.IConsultarProductoService;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
@Log4j2
public class ProductoController {

    private final IConsultarProductoService iConsultarProductoService;

    private final IAccionesProductoService  iAccionesProductoService;

    @GetMapping("/consultar-productos")
    public ResponseEntity<RespuestaGeneralDto> buscarProductosInventario(
            @RequestParam("tipoOrdenamiento") TipoOrdenamientoEnum tipoOrdenamientoEnum,
            @RequestParam("idInventario") Long idInventario
    ){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultarProductoService.buscarProductosInventario(tipoOrdenamientoEnum,idInventario));
        respuesta.setMensaje("Se consulto correctamente");
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/crear")
    public ResponseEntity<RespuestaGeneralDto> crearProducto(@RequestBody ProductoDto producto) throws ErrorGeneralException {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        try {
            iAccionesProductoService.crearProducto(producto);
            respuesta.setStatus(Boolean.TRUE);
            respuesta.setMensaje("Se creo correctamente");
            return ResponseEntity.ok(respuesta);
        }catch (Exception ex){
            log.error(ex);
            throw new ErrorGeneralException(ex.getMessage());
        }
    }


}
