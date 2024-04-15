package com.gov.project.sia.repository;

import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.entity.VentaEntity;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity,Integer> {






}
