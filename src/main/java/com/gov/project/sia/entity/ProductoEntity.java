package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(max = 10)
    @Column(name = "codigo_producto", nullable = false, length = 10)
    private String codigoProducto;

    @NotNull
    @Column(name = "fecha_vencimiento_producto", nullable = false)
    private LocalDate fechaVencimientoProducto;

    @NotNull
    @Column(name = "precio_producto")
    private Double precioProducto;

    @NotNull
    @Column(name = "estado_producto", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private EstadoProductoEnum estadoProducto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_inventario_fk", nullable = false)
    private InventarioEntity idInventarioFk;

    @Column(name = "url_imagen_producto")
    private String urlImagenProducto;

}