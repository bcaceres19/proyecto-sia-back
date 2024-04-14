package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.PedidoDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.entity.PedidoEntity;
import com.gov.project.sia.entity.VentaProductoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoEntity pedidoDtoToPedidoEntity(PedidoDto pedidoDto);


}
