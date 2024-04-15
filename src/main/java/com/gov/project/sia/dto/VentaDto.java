package com.gov.project.sia.dto;

import com.gov.project.sia.entity.PedidoEntity;
import com.gov.project.sia.entity.UsuarioEntity;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

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