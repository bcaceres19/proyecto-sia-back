package com.gov.project.sia.controller;

import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.service.IConsultarProductoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final IConsultarProductoService iConsultarProductoService;

    @GetMapping("/consultar")
    public ResponseEntity<RespuestaGeneralDto> hide(){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultarProductoService.consultarProductos());
        respuesta.setMensaje("Se consulto correctamente");
        return ResponseEntity.ok(respuesta);
    }

}
