package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoTipoProductoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tipo_producto")
public class TipoProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tipo_producto_id_tipo_producto_seq'")
    @Column(name = "id_tipo_producto", nullable = false)
    private Integer idTipoProducto;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre_tipo_producto", nullable = false, length = 50)
    private String nombreTipoProducto;

    @NotNull
    @Column(name = "estado_tipo_producto", nullable = false, length = Integer.MAX_VALUE)
    private EstadoTipoProductoEnum estadoTipoProducto;

}