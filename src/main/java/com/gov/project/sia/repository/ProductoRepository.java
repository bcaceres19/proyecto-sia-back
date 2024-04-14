package com.gov.project.sia.repository;

import com.gov.project.sia.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,String> {

    @Query("""
        select p.codigoProducto, 
        p.idInventarioFk.nombreProductoInventario,
        p.estadoProducto, 
        p.idInventarioFk.precioProductoInventario,
        p.fechaVencimientoProducto from ProductoEntity p
    """)
    List<ProductoEntity> buscarProductos();

}
