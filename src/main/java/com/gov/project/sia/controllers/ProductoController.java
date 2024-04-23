package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.service.output.IConsultarProductoService;
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


}
