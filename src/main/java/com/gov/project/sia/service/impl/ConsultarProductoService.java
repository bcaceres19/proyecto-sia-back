package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.ArbolDto;
import com.gov.project.sia.service.IConsultarProductoService;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

@Service
public class ConsultarProductoService implements IConsultarProductoService {


    @Override
    public void consultarProductos() {
        ArbolDto arbolDto = new ArbolDto();
        arbolDto.insertar(1);
        arbolDto.insertar(10);
        arbolDto.insertar(8);
        arbolDto.insertar(54);
        arbolDto.insertar(15);
        arbolDto.insertar(50);
        arbolDto.insertar(53);
        System.out.println("INORDEN: ");
        arbolDto.dispararInorden();
        System.out.println("POSTORDEN: ");
        arbolDto.dispararPostOrden();
        System.out.println("PREORDEN: ");
        arbolDto.dispararPreorden();

    }


}
