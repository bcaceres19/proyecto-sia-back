package com.gov.project.sia.repository;

import com.gov.project.sia.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity,String> {

    Boolean existsByCodigoPedido(String codigoPedido);

}
