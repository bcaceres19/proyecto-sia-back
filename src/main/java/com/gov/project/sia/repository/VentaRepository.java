package com.gov.project.sia.repository;

import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.entity.VentaEntity;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity,Integer> {


    @Query(value = """
        select v.id_venta, v.cantidad_venta, v.precio_total_venta, v.estado_venta, u.id_usuario from sia.venta v inner join sia.usuario u on v.id_usuario_fk = u.id_usuario
        where u.id_usuario = :idUsuario and v.estado_venta = 'P'
    """, nativeQuery = true)
    List<Object[]> bucarVentaUsuario(@Param("idUsuario") Integer idUsuario);

    VentaEntity findByIdVenta(Integer idVenta);


}
