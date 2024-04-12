package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "venta")
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('venta_id_venta_seq'")
    @Column(name = "id_venta", nullable = false)
    private Integer idVenta;

    @NotNull
    @Column(name = "cantidad_venta", nullable = false)
    private Short cantidadVenta;

    @NotNull
    @Column(name = "estado_venta", nullable = false, length = Integer.MAX_VALUE)
    private EstadoVentaEnum estadoVenta;

    @NotNull
    @Column(name = "fecha_venta", nullable = false)
    private LocalDate fechaVenta;

    @NotNull
    @Column(name = "precio_total_venta", nullable = false, precision = 10, scale = 2)
    private Long precioTotalVenta;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario_fk", nullable = false)
    private UsuarioEntity idUsuarioFk;

    @OneToMany(mappedBy = "idVentaFk")
    private Set<PedidoEntity> pedidos = new LinkedHashSet<>();

}