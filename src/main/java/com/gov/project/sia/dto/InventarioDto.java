package com.gov.project.sia.dto;

import com.gov.project.sia.entity.ProductoEntity;
import com.gov.project.sia.entity.TipoProductoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class InventarioDto {

    private Integer idInventario;

    private Double precioProductoInventario;

    private Integer stockProductoInventario;

    private String nombreProductoInventario;

    private TipoProductoDto idTipoProductoFk;

    private String urlImagenProducto;

}