package com.gov.project.sia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


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

    @Column(name = "precio_producto_inventario", nullable = false)
    private Double precioProductoInventario;

    @Column(name = "stock_producto_inventario", nullable = false)
    private Integer stockProductoInventario;

    @Column(name = "nombre_producto_inventario", nullable = false, length = 50)
    private String nombreProductoInventario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_producto_fk", nullable = false)
    private TipoProductoEntity idTipoProductoFk;

    @Column(name = "url_imagen_producto")
    private String urlImagenProducto;
}