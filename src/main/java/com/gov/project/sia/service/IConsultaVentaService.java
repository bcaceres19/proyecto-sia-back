package com.gov.project.sia.service;

import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.dto.VentaDto;

import java.util.List;

public interface IConsultaVentaService {

    List<VentaDto> consultaVentaUsuarioSinConfirmar(Integer idUsuario);


    List<VentaDto> consultaVentaUsuarioConfirmar(Integer idUsuario);

}
