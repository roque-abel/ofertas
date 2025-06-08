package com.ofertas.infrastructure.repository;

import com.ofertas.infrastructure.entity.CatPerfilEntity;
import com.ofertas.infrastructure.entity.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<CatPerfilEntity,Integer> {
    CatPerfilEntity findByTipoDePerfil(String tipodePerfil);
}
