package com.ofertas.infrastructure.crud;

import com.ofertas.service.dto.OfertaDto;

import java.util.List;

public interface OfertaRepositoryCrud {

    List<OfertaDto> buscarOfertas();
}
