package com.gov.project.sia.dto;

import com.gov.project.sia.entity.PedidoEntity;
import com.gov.project.sia.entity.UsuarioEntity;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class VentaDto {

    private Integer idVenta;

    private Short cantidadVenta;

    private EstadoVentaEnum estadoVenta;

    private LocalDate fechaVenta;

    private Double precioTotalVenta;

    private UsuarioDto idUsuarioFk;

    public VentaDto(Short cantidadVenta,
                    EstadoVentaEnum estadoVenta,
                    LocalDate fechaVenta,
                    Double precioTotalVenta,
                    Integer idUsuarioFk) {
        this.cantidadVenta = cantidadVenta;
        this.estadoVenta = estadoVenta;
        this.fechaVenta = fechaVenta;
        this.precioTotalVenta = precioTotalVenta;
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(idUsuarioFk);
        this.idUsuarioFk = usuarioDto;
    }
}