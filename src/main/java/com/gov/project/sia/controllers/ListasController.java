package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.service.output.IConsultaListasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listas")
@RequiredArgsConstructor
public class ListasController {

    private final IConsultaListasService iConsultaListasService;

    @GetMapping("/consultar-roles-usuario")
    public ResponseEntity<RespuestaGeneralDto> consultarRolesUsuario(){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultaListasService.consultarRolesUsuario());
        respuesta.setMensaje("Se consulto correctamente");
        return  ResponseEntity.ok(respuesta);
    }

    @GetMapping("/consultar-tipos-producto")
    public ResponseEntity<RespuestaGeneralDto> consultarTiposProducto(){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultaListasService.consultarTiposProductos());
        respuesta.setMensaje("Se consulto correctamente");
        return  ResponseEntity.ok(respuesta);
    }

}
