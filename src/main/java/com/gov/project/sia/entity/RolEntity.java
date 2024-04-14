package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoRolEnum;
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
@Table(name = "rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('rol_id_rol_seq'")
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @Size(max = 20)
    @NotNull
    @Column(name = "nombre_rol", nullable = false, length = 20)
    private String nombreRol;

    @NotNull
    @Column(name = "estado_rol", nullable = false, length = Integer.MAX_VALUE)
    private EstadoRolEnum estadoRol;

}