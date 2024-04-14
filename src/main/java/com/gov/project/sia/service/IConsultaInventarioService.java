package com.gov.project.sia.service;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;

import java.util.List;

public interface IConsultaInventarioService {

    List<InventarioDto> buscarProductosInventario(TipoOrdenamientoEnum tipoOrdenamiento);

}
