package com.ofertas.infrastructure.mapeo;

import com.ofertas.infrastructure.entity.CatPerfilEntity;
import com.ofertas.infrastructure.entity.ContratoEntity;
import com.ofertas.infrastructure.entity.ContratoOfertaEntity;
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

    public OfertaEntity ofertaDtoToEntity(OfertaDto oferta){
        OfertaEntity.OfertaEntityBuilder ofertaEntityBuilder = OfertaEntity.builder();
        ofertaEntityBuilder.id(oferta.getId());
        ofertaEntityBuilder.fechaInicio(oferta.getFechaInicio());
        ofertaEntityBuilder.fechaFin(oferta.getFechaFin());
        ofertaEntityBuilder.temporada(oferta.getTemporada());
        OfertaEntity ofertaEntity = ofertaEntityBuilder.build();
        return ofertaEntity;
    }
    public CatPerfilEntity catperfilDtoToEntity(CatPerfilDto perfil){
      CatPerfilEntity.CatPerfilEntityBuilder catPerfilEntityBuilder = CatPerfilEntity.builder();
      catPerfilEntityBuilder.id(perfil.getId());
      catPerfilEntityBuilder.tipoDePerfil(perfil.getTipoDePerfil());
      CatPerfilEntity catPerfilEntity = catPerfilEntityBuilder.build();
        return catPerfilEntity;
    }
    public ContratoEntity contratoDtoToEntity(ContratoDto contrato){
        ContratoEntity.ContratoEntityBuilder contratoEntityBuilder = ContratoEntity.builder();
        contratoEntityBuilder.id(contrato.getId());
        contratoEntityBuilder.idPersona(contrato.getIdPersona());
        contratoEntityBuilder.nombre(contrato.getNombre());
        contratoEntityBuilder.fechaInicio(contrato.getFechaInicio());
        contratoEntityBuilder.fechaFin(contrato.getFechaFin());
        contratoEntityBuilder.fechaFinReal(contrato.getFechaFinReal());
        ContratoEntity contratoEntity = contratoEntityBuilder.build();
        return contratoEntity;
    }
    public ContratoOfertaEntity contratoOfertaDtoToEntity(OfertaDto idOferta, CatPerfilDto idPerfil, ContratoDto idContrato){
        OfertaEntity ofertaEntity = this.ofertaDtoToEntity(idOferta);
        CatPerfilEntity catPerfilEntity = this.catperfilDtoToEntity(idPerfil);
        ContratoEntity contratoEntity = this.contratoDtoToEntity(idContrato);
        ContratoOfertaEntity.ContratoOfertaEntityBuilder contratoOfertaEntityBuilder = ContratoOfertaEntity.builder();
        contratoOfertaEntityBuilder.idOferta(ofertaEntity);
        contratoOfertaEntityBuilder.idCatPerfil(catPerfilEntity);
        contratoOfertaEntityBuilder.idContrato(contratoEntity);
        ContratoOfertaEntity contratoOfertaEntity = contratoOfertaEntityBuilder.build();
        return contratoOfertaEntity;
    }

    public OfertaDto ofertaEntityToDto(OfertaEntity ofertaEntity){
        OfertaDto.OfertaDtoBuilder ofertaDtoBuilder = OfertaDto.builder();
        ofertaDtoBuilder.id(ofertaEntity.getId());
        ofertaDtoBuilder.fechaInicio(ofertaEntity.getFechaInicio());
        ofertaDtoBuilder.fechaFin(ofertaEntity.getFechaFin());
        ofertaDtoBuilder.temporada(ofertaEntity.getTemporada());
        OfertaDto ofertaDto = ofertaDtoBuilder.build();
       return ofertaDto;
    }

}
