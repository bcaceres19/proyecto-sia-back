package com.gov.project.sia.dto;

import com.gov.project.sia.entity.InventarioEntity;
import com.gov.project.sia.entity.VentaEntity;
import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class ProductoDto {

    private String codigoProducto;

    private Double precioProducto;

    private LocalDate fechaVencimientoProducto;

    private EstadoProductoEnum estadoProducto;

    private InventarioDto idInventarioFk;

    private Integer posicionInsercion;

}