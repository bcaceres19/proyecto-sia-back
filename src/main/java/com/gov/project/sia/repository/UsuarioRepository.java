package com.gov.project.sia.repository;

import com.gov.project.sia.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Boolean existsByEmailAndContraseina(String email, String password);

}
