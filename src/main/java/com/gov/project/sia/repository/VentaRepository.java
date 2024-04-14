package com.gov.project.sia.repository;

import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity,Integer> {

    List<VentaEntity> findAllByIdUsuarioFk_IdUsuario(Integer idUsuario);


    @Query("""
        SELECT new com.gov.project.sia.dto.VentaDto(
        i.cantidadVenta,
         i.estadoVenta,
          i.fechaVenta,
           i.precioTotalVenta,
            i.idUsuarioFk.idUsuario
         ) from VentaEntity i inner join
         VentaProductoEntity vp on vp.idVentaFk.idVenta = i.idVenta
         where i.idUsuarioFk.idUsuario = :idUsuario
    """)
    List<VentaDto> buscarVentasConfirmadasUsuario(@Param("idUsuario") Integer idUsuario);


}
