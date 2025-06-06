package com.ofertas.infrastructure.crud;

import com.ofertas.service.dto.CatPerfilDto;

public interface CatPerfilRepositoryCrud {
    CatPerfilDto buscarTipoDePerfil(String tipoDePerfil);
}
