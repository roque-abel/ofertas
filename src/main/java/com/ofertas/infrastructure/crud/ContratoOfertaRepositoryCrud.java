package com.ofertas.infrastructure.crud;

import com.ofertas.infrastructure.entity.CatPerfilEntity;
import com.ofertas.infrastructure.entity.OfertaEntity;
import com.ofertas.service.dto.CatPerfilDto;
import com.ofertas.service.dto.ContratoDto;
import com.ofertas.service.dto.ContratoOfertaDto;
import com.ofertas.service.dto.OfertaDto;

public interface ContratoOfertaRepositoryCrud {
OfertaDto ingregarContratoOferta(OfertaDto idOferta, CatPerfilDto idPerfil, ContratoDto idContrato);
}
