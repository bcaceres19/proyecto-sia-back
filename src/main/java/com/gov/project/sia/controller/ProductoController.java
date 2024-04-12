package com.gov.project.sia.controller;

import com.gov.project.sia.service.IConsultarProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IConsultarProductoService iConsultarProductoService;

    @GetMapping("/")
    public String hide(){
        iConsultarProductoService.consultarProductos();
        return "hide";
    }

}
