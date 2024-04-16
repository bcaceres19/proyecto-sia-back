package com.gov.project.sia.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "venta_producto", schema = "sia")
public class VentaProductoEntity {

    @Id
    @Column(name = "id_venta_producto")
    private Integer idVentaProducto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto_fk", nullable = false)
    private ProductoEntity idProductoFk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_venta_fk", nullable = false)
    private VentaEntity idVentaFk;

}