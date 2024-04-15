package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoPedidoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pedido", schema = "sia")
public class PedidoEntity {
    @Id
    @Size(max = 10)
    @Column(name = "codigo_pedido", nullable = false, length = 10)
    private String codigoPedido;

    @NotNull
    @Column(name = "estado_pedido", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private EstadoPedidoEnum estadoPedido;

    @NotNull
    @Column(name = "fecha_inicio_pedido", nullable = false)
    private LocalDate fechaInicioPedido;

    @NotNull
    @Column(name = "fecha_vencimiento_pedido", nullable = false)
    private LocalDate fechaVencimientoPedido;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario_fk", nullable = false)
    private UsuarioEntity idUsuarioFk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_venta_fk", nullable = false)
    private VentaEntity idVentaFk;

}