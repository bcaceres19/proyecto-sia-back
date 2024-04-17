package com.gov.project.sia.dto;

import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDto {
    private Integer idVenta;

    private Short cantidadVenta;

    private EstadoVentaEnum estadoVenta;

    private LocalDate fechaVenta;

    private Double precioTotalVenta;

    private UsuarioDto idUsuarioFk;

}