package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.service.input.IUsuarioInputService;
import com.gov.project.sia.service.output.IConsultaUsuarioService;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Log4j2
public class UsuarioController {

    private final IConsultaUsuarioService iConsultaUsuarioService;

    private final IUsuarioInputService iUsuarioInputService;

    @PostMapping("/login")
    public ResponseEntity<RespuestaGeneralDto> iniciarSesionUsuario(@RequestBody UsuarioDto usuario) throws ErrorGeneralException {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setData(iConsultaUsuarioService.existeUsuario(usuario.getEmail(), usuario.getContraseina()));
        respuesta.setMensaje("Se consulto correctamente");
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/crear")
    public ResponseEntity<RespuestaGeneralDto> crearUsuario(@RequestBody UsuarioDto usuario) throws ErrorGeneralException {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        try {
            iUsuarioInputService.crearUsuario(usuario);
            respuesta.setStatus(Boolean.TRUE);
            respuesta.setMensaje("Se creo correctamente");
            return ResponseEntity.ok(respuesta);
        }catch (Exception ex){
            log.error(ex);
            throw new ErrorGeneralException(ex.getMessage());
        }
    }
}
