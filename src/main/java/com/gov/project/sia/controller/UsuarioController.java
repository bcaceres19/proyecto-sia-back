package com.gov.project.sia.controller;

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

    @Autowired
    private IConsultaUsuarioService iConsultaUsuarioService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> iniciarSesionUsuario(@RequestBody UsuarioDto usuario) throws ErrorGeneralException {
        return ResponseEntity.ok(iConsultaUsuarioService.existeUsuario(usuario.getEmail(), usuario.getContraseina()));
    }

}
