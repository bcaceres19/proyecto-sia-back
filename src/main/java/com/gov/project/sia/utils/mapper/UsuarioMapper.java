package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.entity.ProductoEntity;
import com.gov.project.sia.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDto entityToDto(UsuarioEntity usuarioEntity);

    UsuarioEntity dtoToEntity(UsuarioDto usuarioDto);

}
