package com.gov.project.sia.controller;

import com.gov.project.sia.dto.ColaDto;
import com.gov.project.sia.dto.NodoPilaDto;
import com.gov.project.sia.dto.OrquestadorPilaDto;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prueba")
@Log4j2
public class PruebaController {

    @GetMapping
    public String hide(){

        return "hide";
    }

}
