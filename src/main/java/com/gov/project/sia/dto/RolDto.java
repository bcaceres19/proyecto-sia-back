package com.gov.project.sia.dto;

import com.gov.project.sia.utils.enums.EstadoRolEnum;
import lombok.Data;


@Data
public class RolDto {

    private Integer idRol;

    private String nombreRol;

    private EstadoRolEnum estadoRol;

}