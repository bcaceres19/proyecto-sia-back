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

    List<VentaProductoEntity> findAllByIdVentaFk_IdUsuarioFk_IdUsuarioAndIdVentaFk_EstadoVentaOrderByIdVentaFk_IdVentaAsc(Integer idUsuario, EstadoVentaEnum estado);

    @Query(value = """
        select
            p.codigo_producto,
            p.fecha_vencimiento_producto,
            p.precio_producto,
            p.estado_producto
        from sia.venta_producto vp
        inner join sia.producto p 
        ON vp.id_producto_fk = p.codigo_producto
    """, nativeQuery = true)
    List<Object[]> buscarProductosVentas(@Param("codigoProducto") String codigoProducto);

    @Query("""
        SELECT new com.gov.project.sia.dto.VentaProductoDto(
        vp.idVentaFk,
        vp.idProductoFk
         ) from VentaEntity i inner join
         VentaProductoEntity vp on vp.idVentaFk.idVenta = i.idVenta
         where i.idUsuarioFk.idUsuario = :idUsuario AND i.estadoVenta = 'T'
          order by i.idVenta asc
    """)
    List<VentaProductoDto> buscarVentasPendientesRevisionUsuario(@Param("idUsuario") Integer idUsuario);

}
