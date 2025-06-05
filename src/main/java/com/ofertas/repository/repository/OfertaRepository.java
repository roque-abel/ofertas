package com.ofertas.repository.repository;

import com.ofertas.repository.entity.OfertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepository extends JpaRepository<OfertaEntity, Integer> {
}
