package com.gov.project.sia.service.output;

import com.gov.project.sia.dto.VentaProductoRespuestaDto;

public interface IConsultaVentaProductoService {

    VentaProductoRespuestaDto consultaVentaUsuarioSinConfirmar(Integer idUsuario);

    VentaProductoRespuestaDto consultaVentaUsuarioConfirmar(Integer idUsuario);


}
