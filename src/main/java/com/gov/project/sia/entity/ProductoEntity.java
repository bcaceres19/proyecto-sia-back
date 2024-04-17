package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "producto", schema = "sia")
public class ProductoEntity {
    @Id
    @Column(name = "codigo_producto", nullable = false, length = 10)
    private String codigoProducto;

    @Column(name = "fecha_vencimiento_producto", nullable = false)
    private LocalDate fechaVencimientoProducto;

    @Column(name = "precio_producto")
    private Double precioProducto;

    @Column(name = "estado_producto", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private EstadoProductoEnum estadoProducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_inventario_fk", nullable = false)
    private InventarioEntity idInventarioFk;



}