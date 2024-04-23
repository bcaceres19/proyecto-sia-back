package com.gov.project.sia.repository;

import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,String> {

    @Query(value = """
        select 
            row_number() over (order by p.codigo_producto ) as indice,
            p.codigo_producto, 
        p.fecha_vencimiento_producto,
        tp.nombre_tipo_producto,
        p.precio_producto,
        p.estado_producto  from
        sia.producto p inner join sia.inventario i on p.id_inventario_fk = i.id_inventario 
            inner join sia.tipo_producto tp
        on i.id_tipo_producto_fk = tp.id_tipo_producto
        where p.id_inventario_fk = :idInventario order by RANDOM()
    """, nativeQuery = true)
    List<Object[]> consultarProductosInventario(@Param("idInventario") Long idInventario);

    ProductoEntity findByCodigoProducto(String codigoProducto);

    Boolean existsByCodigoProducto(String codigoProducto);

}
