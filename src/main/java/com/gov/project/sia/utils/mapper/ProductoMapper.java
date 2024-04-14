package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.entity.InventarioEntity;
import com.gov.project.sia.entity.ProductoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDto productoEntityToProductoDto(ProductoEntity productoEntity);


}
