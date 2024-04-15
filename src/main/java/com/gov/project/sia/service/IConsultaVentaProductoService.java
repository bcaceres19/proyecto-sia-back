package com.gov.project.sia.service;

import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaProductoDto;

import java.util.List;

public interface IConsultaVentaProductoService {

    List<VentaProductoDto> consultaVentaUsuarioSinConfirmar(Integer idUsuario);

    List<VentaProductoDto> consultaVentaUsuarioConfirmar(Integer idUsuario);


}
