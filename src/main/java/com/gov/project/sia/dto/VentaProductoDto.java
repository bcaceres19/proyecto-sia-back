package com.gov.project.sia.dto;

import com.gov.project.sia.entity.ProductoEntity;
import com.gov.project.sia.entity.VentaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class VentaProductoDto {


    private ProductoDto idProductoFk;


    private VentaDto idVentaFk;

}