package com.gov.project.sia.repository;

import com.gov.project.sia.dto.InventarioRespuestaDto;
import com.gov.project.sia.entity.InventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Integer> {

    @Query(value = """
            select i.id_inventario, 
                   i.nombre_producto_inventario, 
                   i.url_imagen_producto  from sia.inventario i;
    """, nativeQuery = true)
    List<Object[]> buscarInventario();

    @Query(value = """
        SELECT NEW com.gov.project.sia.dto.InventarioRespuestaDto(i.idInventario, i.nombreProductoInventario, i.urlImagenProducto) 
        FROM InventarioEntity i where LOWER(i.nombreProductoInventario) LIKE LOWER(CONCAT('%', :nombre, '%'))
    """)
    List<InventarioRespuestaDto> buscarInventarioNombre(@Param("nombre")String nombre);

    @Query(value = """
            SELECT NEW com.gov.project.sia.dto.InventarioRespuestaDto(i.idInventario, i.nombreProductoInventario) 
            FROM InventarioEntity i
    """)
    List<InventarioRespuestaDto> consultarTiposInventario();

    @Query(value = """
        select p.codigo_producto,
               p.estado_producto, 
               p.precio_producto, 
               p.fecha_vencimiento_producto from sia.producto p where p.precio_producto in (
    	select p.precio_producto from sia.inventario i inner join sia.producto p on i.id_inventario  = p.id_inventario_fk
    	where i.id_inventario = :idInventario group by p.precio_producto order by count(p.precio_producto) desc limit 1
        ) limit 1
    """,nativeQuery = true)
    List<Object[]> buscarDetalleInventario(@Param("idInventario") Integer idInventario);

}
