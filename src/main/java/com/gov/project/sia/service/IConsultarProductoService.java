package com.gov.project.sia.service;

import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.ProductoRespuestaDto;

import java.util.List;

public interface IConsultarProductoService {

    List<ProductoRespuestaDto> consultarProductos();
}
