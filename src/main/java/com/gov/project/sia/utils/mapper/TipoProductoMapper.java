package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.RolDto;
import com.gov.project.sia.dto.TipoProductoDto;
import com.gov.project.sia.entity.RolEntity;
import com.gov.project.sia.entity.TipoProductoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoProductoMapper {

    TipoProductoDto entityToDto(TipoProductoEntity entity);


}
