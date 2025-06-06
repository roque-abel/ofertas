package com.ofertas.infrastructure.repository;

import com.ofertas.infrastructure.entity.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ContratoRepository extends JpaRepository<ContratoEntity,Integer> {

    List<ContratoEntity> findByidPersona(Integer personasId);

    List<ContratoEntity> findByFechaFinAfterAndFechaFinRealEqualsAndFechaFinRealEquals(LocalDate fechaFinReal, LocalDate fechaFin, LocalDate vacio);
}
