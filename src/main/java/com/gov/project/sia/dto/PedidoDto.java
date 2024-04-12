package com.gov.project.sia.dto;

import com.gov.project.sia.entity.UsuarioEntity;
import com.gov.project.sia.entity.VentaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class PedidoDto {

    private String codigoPedido;

    private String estadoPedido;

    private LocalDate fechaInicioPedido;

    private LocalDate fechaVencimientoPedido;

    private UsuarioDto idUsuarioFk;

    private VentaDto idVentaFk;

}