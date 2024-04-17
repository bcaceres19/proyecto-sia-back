package com.gov.project.sia.repository;

import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.entity.VentaEntity;
import com.gov.project.sia.entity.VentaProductoEntity;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaProductoRepository extends JpaRepository<VentaProductoEntity, Integer> {

    @Query("""
        SELECT new com.gov.project.sia.dto.VentaProductoDto(
        vp.idVentaProducto,
        vp.idVentaFk,
        vp.idProductoFk
         ) from VentaProductoEntity vp  inner join
         VentaEntity i on vp.idVentaFk.idVenta = i.idVenta
         where i.idUsuarioFk.idUsuario = :idUsuario AND i.estadoVenta = 'P'
          order by i.idVenta asc
    """)
    List<VentaProductoDto> buscarVentasNuevasUsuario(@Param("idUsuario") Integer idUsuario);

    @Query(value = """


            select
                    p.codigo_producto,
                    p.fecha_vencimiento_producto,
                    p.precio_producto,
                    p.estado_producto,
                    i.nombre_producto_inventario,
                    i.stock_producto_inventario,
                    i.precio_producto_inventario
                from sia.pedido pe inner join sia.venta_producto vp on pe.id_venta_fk = vp.id_venta_fk\s
                inner join sia.producto p
                ON vp.id_producto_fk = p.codigo_producto inner join
               sia.inventario i on p.id_inventario_fk = i.id_inventario
               where pe.codigo_pedido  = :codigoPedido
        
    """, nativeQuery = true)
    List<Object[]> buscarProductosVentas(@Param("codigoPedido") String  codigoPedido);

    @Query("""
        SELECT new com.gov.project.sia.dto.VentaProductoDto(
        vp.idVentaProducto,
        vp.idVentaFk,
        vp.idProductoFk
         ) from VentaEntity i inner join
         VentaProductoEntity vp on vp.idVentaFk.idVenta = i.idVenta
         where i.idUsuarioFk.idUsuario = :idUsuario AND i.estadoVenta = 'T'
          order by i.idVenta asc
    """)
    List<VentaProductoDto> buscarVentasPendientesRevisionUsuario(@Param("idUsuario") Integer idUsuario);

    Integer deleteByIdVentaProducto(Integer idVentaProducto);

    VentaProductoEntity findByIdVentaProducto(Integer idVentaProducto);

}
