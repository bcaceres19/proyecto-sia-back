package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "venta", schema = "sia")
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('venta_id_venta_seq'")
    @Column(name = "id_venta", nullable = false)
    private Integer idVenta;

    @Column(name = "cantidad_venta", nullable = false)
    private Short cantidadVenta;

    @Column(name = "estado_venta", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private EstadoVentaEnum estadoVenta;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDate fechaVenta;

    @Column(name = "precio_total_venta", nullable = false)
    private Double precioTotalVenta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario_fk", nullable = false)
    private UsuarioEntity idUsuarioFk;



}