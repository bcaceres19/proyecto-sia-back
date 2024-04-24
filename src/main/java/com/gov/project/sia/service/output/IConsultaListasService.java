package com.gov.project.sia.service.output;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.InventarioRespuestaDto;
import com.gov.project.sia.dto.RolDto;
import com.gov.project.sia.dto.TipoProductoDto;
import com.gov.project.sia.utils.enums.EstadoProductoEnum;

import java.util.List;

public interface IConsultaListasService {

    List<RolDto> consultarRolesUsuario();

    List<TipoProductoDto> consultarTiposProductos();

    List<InventarioRespuestaDto> consultarTiposInventarios();

    List<String> consultarEstadoProductos();

}
