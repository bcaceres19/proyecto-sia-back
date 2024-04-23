package com.gov.project.sia.service.output;

import com.gov.project.sia.dto.RolDto;
import com.gov.project.sia.dto.TipoProductoDto;

import java.util.List;

public interface IConsultaListasService {

    List<RolDto> consultarRolesUsuario();

    List<TipoProductoDto> consultarTiposProductos();

}
