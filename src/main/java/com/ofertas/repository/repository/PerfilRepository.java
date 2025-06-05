package com.ofertas.repository.repository;

import com.ofertas.repository.entity.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<ContratoEntity,Integer> {
}
