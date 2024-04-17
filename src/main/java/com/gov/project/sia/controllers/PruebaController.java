package com.gov.project.sia.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
@Log4j2
public class PruebaController {

    @GetMapping
    public String hide(){

        return "hide";
    }

}
