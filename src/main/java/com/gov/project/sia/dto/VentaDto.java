package com.gov.project.sia.dto;

import com.gov.project.sia.entity.PedidoEntity;
import com.gov.project.sia.entity.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class VentaDto {

    private Integer idVenta;

    private Short cantidadVenta;

    private String estadoVenta;

    private LocalDate fechaVenta;

    private Long precioTotalVenta;

    private UsuarioDto idUsuarioFk;

    private Set<PedidoDto> pedidos = new LinkedHashSet<>();

}