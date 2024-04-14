package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.entity.InventarioEntity;
import com.gov.project.sia.entity.VentaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {

    VentaEntity ventaDtoToVentaEntity(VentaDto ventaDto);

    VentaDto VentaEntityToVentaDto(VentaEntity ventaDto);


}
