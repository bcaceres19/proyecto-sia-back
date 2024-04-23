package com.gov.project.sia.repository;

import com.gov.project.sia.entity.TipoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProductoEntity,Integer> {
}
