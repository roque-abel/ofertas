package com.ofertas.infrastructure.daoRepository;

import com.ofertas.infrastructure.crud.ContratoOfertaRepositoryCrud;
import com.ofertas.infrastructure.entity.ContratoOfertaEntity;
import com.ofertas.infrastructure.entity.OfertaEntity;
import com.ofertas.infrastructure.mapeo.Mapeo;
import com.ofertas.infrastructure.repository.ContratoOfertaReporsitory;
import com.ofertas.service.dto.CatPerfilDto;
import com.ofertas.service.dto.ContratoDto;
import com.ofertas.service.dto.ContratoOfertaDto;
import com.ofertas.service.dto.OfertaDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DaoRepositoryContratoOferta implements ContratoOfertaRepositoryCrud {
    private final ContratoOfertaReporsitory contratoOfertaReporsitory;
    private final Mapeo mapeo;

    @Override
    public OfertaDto ingregarContratoOferta(OfertaDto idOferta, CatPerfilDto idPerfil, ContratoDto idContrato) {
        ContratoOfertaEntity contratoOfertaEntity = this.mapeo.contratoOfertaDtoToEntity(idOferta,idPerfil,idContrato);
        this.contratoOfertaReporsitory.save(contratoOfertaEntity);
        ContratoOfertaEntity registroCotOferta =  this.contratoOfertaReporsitory.findTopByOrderByIdDesc();
        OfertaEntity oferta = registroCotOferta.getIdOferta();
        return this.mapeo.ofertaEntityToDto(oferta);
    }
}
