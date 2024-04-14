package com.gov.project.sia.dto;

import com.gov.project.sia.entity.InventarioEntity;
import com.gov.project.sia.utils.enums.EstadoTipoProductoEnum;
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
public class TipoProductoDto {

    private Integer idTipoProducto;

    private String nombreTipoProducto;

    private EstadoTipoProductoEnum estadoTipoProducto;

}