package com.gov.project.sia.dto;

import com.gov.project.sia.entity.PedidoEntity;
import com.gov.project.sia.entity.RolEntity;
import com.gov.project.sia.entity.VentaEntity;
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
public class UsuarioDto {

    private Integer idUsuario;

    private String nombres;

    private String apellidos;

    private String telefono;

    private String email;

    private String contraseina;

    private RolDto idRolFk;



}