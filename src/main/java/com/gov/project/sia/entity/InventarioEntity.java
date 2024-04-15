package com.gov.project.sia.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "inventario", schema = "sia")
public class InventarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('inventario_id_inventario_seq'")
    @Column(name = "id_inventario", nullable = false)
    private Integer idInventario;

    @NotNull
    @Column(name = "precio_producto_inventario", nullable = false)
    private Double precioProductoInventario;

    @NotNull
    @Column(name = "stock_producto_inventario", nullable = false)
    private Integer stockProductoInventario;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre_producto_inventario", nullable = false, length = 50)
    private String nombreProductoInventario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_producto_fk", nullable = false)
    private TipoProductoEntity idTipoProductoFk;

}