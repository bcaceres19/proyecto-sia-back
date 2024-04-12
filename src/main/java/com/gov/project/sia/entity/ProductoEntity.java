package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoProductoEnum;
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
@Table(name = "producto")
public class ProductoEntity {
    @Id
    @Size(max = 10)
    @Column(name = "codigo_producto", nullable = false, length = 10)
    private String codigoProducto;

    @NotNull
    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @NotNull
    @Column(name = "estado_producto", nullable = false, length = Integer.MAX_VALUE)
    private EstadoProductoEnum estadoProducto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_inventario_fk", nullable = false)
    private InventarioEntity idInventarioFk;
}