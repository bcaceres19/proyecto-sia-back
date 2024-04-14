package com.gov.project.sia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('usuario_id_usuario_seq'")
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Size(max = 20)
    @Column(name = "telefono", length = 20)
    private String telefono;

    @Size(max = 20)
    @Column(name = "email", length = 20)
    private String email;

    @Size(max = 20)
    @NotNull
    @Column(name = "contraseina", nullable = false, length = 20)
    private String contraseina;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_rol_fk", nullable = false)
    private RolEntity idRolFk;

}