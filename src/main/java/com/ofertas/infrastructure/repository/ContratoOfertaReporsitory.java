package com.ofertas.infrastructure.repository;

import com.ofertas.infrastructure.entity.ContratoOfertaEntity;
import com.ofertas.infrastructure.entity.OfertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoOfertaReporsitory extends JpaRepository<ContratoOfertaEntity,Integer> {
    ContratoOfertaEntity findTopByOrderByIdDesc();

}
