package com.gov.project.sia.controller;

import com.gov.project.sia.service.IConsultaUsuarioService;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private IConsultaUsuarioService iConsultaUsuarioService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> iniciarSesionUsuario(String email, String password) throws ErrorGeneralException {
        return ResponseEntity.ok(iConsultaUsuarioService.existeUsuario(email, password));
    }

}
