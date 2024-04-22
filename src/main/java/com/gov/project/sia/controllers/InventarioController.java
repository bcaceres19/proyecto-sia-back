package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.InventarioInputDto;
import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.service.IConsultaInventarioService;
import com.gov.project.sia.service.IConsultarProductoService;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private final IConsultaInventarioService iConsultaInventarioService;

    @PostMapping("/consultar-inventario")
    public ResponseEntity<RespuestaGeneralDto> consultaInventario(
            @RequestBody InventarioInputDto inventarioInput
    ){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultaInventarioService.consultarInventario(inventarioInput.getTipoOrdenamiento(), inventarioInput.getInventariosRespuesta()));
        respuesta.setMensaje("Se consulto correctamente");
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/consultar-inventario-nombre")
    public ResponseEntity<RespuestaGeneralDto> consultarInventarioNombre(
            @RequestBody InventarioInputDto inventarioInput
    ){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultaInventarioService.consultarInventarioNombre(inventarioInput.getTipoOrdenamiento(), inventarioInput.getNombre()));
        respuesta.setMensaje("Se consulto correctamente");
        return ResponseEntity.ok(respuesta);
    }

}
