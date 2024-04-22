package com.gov.project.sia.service;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.InventarioRespuestaDto;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;

import java.util.List;

public interface IConsultaInventarioService {


    List<InventarioRespuestaDto> consultarInventario(TipoOrdenamientoEnum tipoOrdenamientoEnum, List<InventarioRespuestaDto> inventarioActual);

    List<InventarioRespuestaDto> consultarInventarioNombre(TipoOrdenamientoEnum tipoOrden, String nombre);

}
