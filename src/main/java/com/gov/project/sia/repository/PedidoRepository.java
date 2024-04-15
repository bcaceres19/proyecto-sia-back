package com.gov.project.sia.repository;

import com.gov.project.sia.dto.RespuestaPedidoDto;
import com.gov.project.sia.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity,String> {

    Boolean existsByCodigoPedido(String codigoPedido);

    @Query(value = """
        SELECT new com.gov.project.sia.dto.RespuestaPedidoDto(
        pe.codigoPedido,
        pe.fechaInicioPedido,
         pe.fechaVencimientoPedido,
          v.cantidadVenta,
           v.precioTotalVenta ) FROM VentaProductoEntity vp
        inner join VentaEntity v on vp.idVentaFk = v inner join ProductoEntity p
        on vp.idProductoFk = p inner join PedidoEntity pe 
        on vp.idVentaFk = pe.idVentaFk where pe.estadoPedido = 'P'
    """)
    List<RespuestaPedidoDto> buscarPedidosPendientes();

}
