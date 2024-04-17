package com.gov.project.sia.dto;

import com.gov.project.sia.utils.enums.EstadoTipoProductoEnum;
import lombok.Data;


@Data
public class TipoProductoDto {

    private Integer idTipoProducto;

    private String nombreTipoProducto;

    private EstadoTipoProductoEnum estadoTipoProducto;

}