package com.gov.project.sia.repository;

import com.gov.project.sia.entity.InventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Integer> {

    @Query(value = """
        SELECT i.id_inventario, 
        i.precio_producto_inventario, 
        i.stock_producto_inventario,
        i.nombre_producto_inventario,
        tp.nombre_tipo_producto from sia.inventario i inner join 
        sia.tipo_producto tp ON i.id_tipo_producto_fk = tp.id_tipo_producto ORDER BY RANDOM();
    """, nativeQuery = true)
    List<Object[]> consultarProductosInventario();

}
