package com.gov.project.sia.entity;

import com.gov.project.sia.utils.enums.EstadoRolEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


@Getter
@Setter
@Entity
@Table(name = "rol", schema = "sia")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('rol_id_rol_seq'")
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @Column(name = "nombre_rol", nullable = false, length = 20)
    private String nombreRol;

    @Column(name = "estado_rol", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private EstadoRolEnum estadoRol;

}