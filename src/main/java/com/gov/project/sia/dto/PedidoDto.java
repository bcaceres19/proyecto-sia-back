package com.gov.project.sia.dto;

import com.gov.project.sia.utils.enums.EstadoPedidoEnum;
import lombok.Data;


import java.time.LocalDate;

@Data
public class PedidoDto {

    private String codigoPedido;

    private EstadoPedidoEnum estadoPedido;

    private LocalDate fechaInicioPedido;

    private LocalDate fechaVencimientoPedido;

    private UsuarioDto idUsuarioFk;

    private VentaDto idVentaFk;

}