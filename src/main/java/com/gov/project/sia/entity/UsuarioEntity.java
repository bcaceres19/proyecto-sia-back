package com.gov.project.sia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


@Getter
@Setter
@Entity
@Table(name = "usuario", schema = "sia")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('usuario_id_usuario_seq'")
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;


    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "contraseina", nullable = false, length = 20)
    private String contraseina;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_rol_fk", nullable = false)
    private RolEntity idRolFk;

}