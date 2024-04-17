package com.gov.project.sia.repository;

import com.gov.project.sia.dto.RespuestaPedidoDto;
import com.gov.project.sia.entity.PedidoEntity;
import com.gov.project.sia.utils.enums.EstadoPedidoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity,String> {

    Boolean existsByCodigoPedido(String codigoPedido);

    PedidoEntity findByCodigoPedido(String codigoPedido);

    @Query(value = """
        SELECT distinct new com.gov.project.sia.dto.RespuestaPedidoDto(
        pe.codigoPedido,
        pe.fechaInicioPedido,
         pe.fechaVencimientoPedido,
          v.cantidadVenta,
           v.precioTotalVenta ) FROM VentaProductoEntity vp
        inner join VentaEntity v on vp.idVentaFk = v inner join ProductoEntity p
        on vp.idProductoFk = p inner join PedidoEntity pe
        on vp.idVentaFk = pe.idVentaFk where pe.estadoPedido = :estadoPedido order by pe.codigoPedido asc
    """)
    List<RespuestaPedidoDto> buscarPedidosPendientes(@Param("estadoPedido") EstadoPedidoEnum estadoPedido);

    @Query(value = """
        select u.nombres, u.email, u.telefono,v.cantidad_venta, v.precio_total_venta
        from sia.pedido p inner join sia.usuario u on p.id_usuario_fk = u.id_usuario
        inner join sia.venta v on p.id_venta_fk = v.id_venta where p.codigo_pedido = :codigoPedido
    """, nativeQuery = true)
    List<Object[]> buscarDataRepore(@Param("codigoPedido") String codigoPedido);

    @Query(value = """
            select p.codigo_pedido, 
            v.cantidad_venta ,
             v.precio_total_venta, 
             v.fecha_venta, p.fecha_inicio_pedido 
    from sia.pedido p inner join sia.venta_producto vp
    on p.id_venta_fk = vp.id_venta_fk
    inner join sia.venta v on vp.id_venta_fk = v.id_venta inner join sia.usuario u on
    p.id_usuario_fk = u.id_usuario where (:idUsuario is null or u.id_usuario = :idUsuario)
    and p.estado_pedido = 'A'
    """, nativeQuery = true)
    List<Object[]> buscarPedidosCompletados(@Param("idUsuario") Integer idUsuario);

    @Query(value = """
    select p2.codigo_producto, p2.precio_producto, p2.fecha_vencimiento_producto, p.codigo_pedido,
         p.fecha_inicio_pedido, v.fecha_venta
            from sia.pedido  p inner join sia.venta_producto vp on p.id_venta_fk  = vp.id_venta_fk
            inner join sia.producto p2 on vp.id_producto_fk = p2.codigo_producto inner join sia.venta v
         on vp.id_venta_fk = v.id_venta where p.codigo_pedido = :codigoPedido
    """,nativeQuery = true)
    List<Object[]> buscarDataSubReporte(@Param("codigoPedido") String codigoPedido);
}
