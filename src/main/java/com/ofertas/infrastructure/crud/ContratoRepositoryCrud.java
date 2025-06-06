package com.ofertas.infrastructure.crud;

import com.ofertas.infrastructure.entity.ContratoEntity;
import com.ofertas.service.dto.ContratoDto;

import java.util.List;

public interface ContratoRepositoryCrud {
    List<ContratoDto> buscarContratosPorPersona(Integer personaId);


}
