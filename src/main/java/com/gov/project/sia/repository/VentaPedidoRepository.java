package com.gov.project.sia.repository;

import com.gov.project.sia.entity.VentaProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaPedidoRepository extends JpaRepository<VentaProductoEntity, Long> {
}
