package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoPedidoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pedido", schema = "sia")
public class PedidoEntity {
    @Id
    @Column(name = "codigo_pedido", nullable = false, length = 10)
    private String codigoPedido;

    @Column(name = "estado_pedido", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private EstadoPedidoEnum estadoPedido;

    @Column(name = "fecha_inicio_pedido", nullable = false)
    private LocalDate fechaInicioPedido;

    @Column(name = "fecha_vencimiento_pedido", nullable = false)
    private LocalDate fechaVencimientoPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario_fk", nullable = false)
    private UsuarioEntity idUsuarioFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_venta_fk", nullable = false)
    private VentaEntity idVentaFk;

}