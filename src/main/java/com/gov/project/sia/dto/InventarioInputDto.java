package com.gov.project.sia.dto;

import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import lombok.Data;

import java.util.List;

@Data
public class InventarioInputDto {

    private TipoOrdenamientoEnum tipoOrdenamiento;
    private String nombre;
    private List<InventarioRespuestaDto>  inventariosRespuesta;

}
