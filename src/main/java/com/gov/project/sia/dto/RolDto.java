package com.gov.project.sia.dto;

import com.gov.project.sia.entity.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class RolDto {

    private Integer idRol;

    private String nombreRol;

    private String estadoRol;

    private Set<UsuarioDto> usuarios = new LinkedHashSet<>();

}