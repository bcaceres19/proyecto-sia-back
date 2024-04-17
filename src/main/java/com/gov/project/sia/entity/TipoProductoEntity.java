package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoTipoProductoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


@Getter
@Setter
@Entity
@Table(name = "tipo_producto", schema = "sia")
public class TipoProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tipo_producto_id_tipo_producto_seq'")
    @Column(name = "id_tipo_producto", nullable = false)
    private Integer idTipoProducto;


    @Column(name = "nombre_tipo_producto", nullable = false, length = 50)
    private String nombreTipoProducto;

    @Column(name = "estado_tipo_producto", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private EstadoTipoProductoEnum estadoTipoProducto;

}