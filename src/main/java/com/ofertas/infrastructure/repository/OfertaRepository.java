package com.ofertas.infrastructure.repository;

import com.ofertas.infrastructure.entity.OfertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OfertaRepository extends JpaRepository<OfertaEntity, Integer> {
    List<OfertaEntity> findByFechaInicioBetween(LocalDate fechaPrimera, LocalDate fechaSegunda);
}
