package com.gov.project.sia.repository;

import com.gov.project.sia.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,String> {

    @Query(value = """
            select p.codigo_producto,
             p.estado_producto,
              i.precio_producto_inventario, 
              p.precio_producto, 
              p.fecha_vencimiento_producto,
               i.nombre_producto_inventario,
               i.url_imagen_producto
            from sia.producto p inner join 
            sia.inventario i on p.id_inventario_fk  = i.id_inventario;
    """, nativeQuery = true)
    List<Object[]> buscarProductos();

}
