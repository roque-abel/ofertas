package com.ofertas.service.dto;

import com.ofertas.infrastructure.entity.CatPerfilEntity;
import com.ofertas.infrastructure.entity.ContratoEntity;
import com.ofertas.infrastructure.entity.OfertaEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContratoOfertaDto {

    private ContratoEntity idContrato;
    private OfertaEntity idOferta;
    private CatPerfilEntity idCatPerfil;
}
