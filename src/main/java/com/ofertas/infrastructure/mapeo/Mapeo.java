package com.ofertas.infrastructure.mapeo;

import com.ofertas.infrastructure.entity.CatPerfilEntity;
import com.ofertas.infrastructure.entity.ContratoEntity;
import com.ofertas.infrastructure.entity.OfertaEntity;
import com.ofertas.service.dto.CatPerfilDto;
import com.ofertas.service.dto.ContratoDto;
import com.ofertas.service.dto.OfertaDto;
import com.ofertas.service.model.OfertaModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapeo {

    public List<ContratoDto> listContratoEntityToDto(List<ContratoEntity> contratosEntityList) {
        return contratosEntityList.stream()
                .map(contratoEntity -> {
                    ContratoDto.ContratoDtoBuilder contratoDtoBuilder = ContratoDto.builder();
                    contratoDtoBuilder.id(contratoEntity.getId());
                    contratoDtoBuilder.idPersona(contratoEntity.getIdPersona());
                    contratoDtoBuilder.fechaInicio(contratoEntity.getFechaInicio());
                    contratoDtoBuilder.fechaFin(contratoEntity.getFechaFin());
                    contratoDtoBuilder.fechaFinReal(contratoEntity.getFechaFinReal());
                    ContratoDto contratoDto = contratoDtoBuilder.build();
                    return contratoDto;

                })
                .collect(Collectors.toList());
    }

    public List<OfertaDto> ofertaEntityToDto(List<OfertaEntity> ofertaEntity) {
        return ofertaEntity.stream()
                .map(oderta -> {


                    OfertaDto.OfertaDtoBuilder ofertaDtoBuilder = OfertaDto.builder();
                    ofertaDtoBuilder.id(oderta.getId());
                    ofertaDtoBuilder.fechaInicio(oderta.getFechaInicio());
                    ofertaDtoBuilder.fechaFin(oderta.getFechaFin());
                    ofertaDtoBuilder.temporada(oderta.getTemporada());
                    OfertaDto ofertaDto = ofertaDtoBuilder.build();
                    return ofertaDto;
                })
                .collect(Collectors.toList());
    }

    public CatPerfilDto catPerfilEntityToDo(CatPerfilEntity perfilEntity) {
        CatPerfilDto.CatPerfilDtoBuilder catPerfilDtoBuilder = CatPerfilDto.builder();
        catPerfilDtoBuilder.id(perfilEntity.getId());
        catPerfilDtoBuilder.tipoDePerfil(perfilEntity.getTipoDePerfil());
        CatPerfilDto perfilDto = catPerfilDtoBuilder.build();
        return perfilDto;
    }
}
