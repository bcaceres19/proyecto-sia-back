package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.service.IConsultarProductoService;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final IConsultarProductoService iConsultarProductoService;

    @GetMapping("/consultar")
    public ResponseEntity<RespuestaGeneralDto> dataProductosAct(@RequestParam("tipoOrdenamiento") TipoOrdenamientoEnum tipoOrdenamientoEnum){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultarProductoService.consultarProductos(tipoOrdenamientoEnum));
        respuesta.setMensaje("Se consulto correctamente");
        return ResponseEntity.ok(respuesta);
    }

}
