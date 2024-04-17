package com.gov.project.sia.dto;


import lombok.Data;

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