package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.service.IConsultaUsuarioService;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final IConsultaUsuarioService iConsultaUsuarioService;

    @PostMapping("/login")
    public ResponseEntity<RespuestaGeneralDto> iniciarSesionUsuario(@RequestBody UsuarioDto usuario) throws ErrorGeneralException {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setData(iConsultaUsuarioService.existeUsuario(usuario.getEmail(), usuario.getContraseina()));
        respuesta.setMensaje("Se consulto correctamente");
        return ResponseEntity.ok(respuesta);
    }

}
