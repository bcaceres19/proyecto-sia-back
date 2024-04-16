package com.gov.project.sia.service;

import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.dto.VentaProductoRespuestaDto;

import java.util.List;

public interface IConsultaVentaProductoService {

    VentaProductoRespuestaDto consultaVentaUsuarioSinConfirmar(Integer idUsuario);

    VentaProductoRespuestaDto consultaVentaUsuarioConfirmar(Integer idUsuario);


}
