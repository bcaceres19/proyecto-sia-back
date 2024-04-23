package com.gov.project.sia.utils.mapper;

import com.gov.project.sia.dto.RolDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.entity.RolEntity;
import com.gov.project.sia.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolMapper {

    RolDto entityToDto(RolEntity rol);


}
