package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.entity.InventarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventarioMapper {

    InventarioDto inventarioEntityToInventarioDto(InventarioEntity inventarioEntity);

    InventarioEntity inventarioDtoToInventarioEntity(InventarioDto inventarioDto);

}
