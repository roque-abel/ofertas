package com.ofertas.service;

import com.ofertas.infrastructure.crud.CatPerfilRepositoryCrud;
import com.ofertas.infrastructure.crud.ContratoOfertaRepositoryCrud;
import com.ofertas.infrastructure.crud.ContratoRepositoryCrud;
import com.ofertas.service.dto.*;
import com.ofertas.service.model.OfertaModel;
import com.ofertas.service.properties.PropertiesValues;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {
    private final ContratoRepositoryCrud contratoRepositoryCrud;
    private final PropertiesValues propertiesValues;
    private final ContratoOfertaRepositoryCrud contratoOfertaRepositoryCrud;
    private final com.ofertas.infrastructure.crud.OfertaRepositoryCrud OfertaRepositoryCrud;
    private final CatPerfilRepositoryCrud catPerfilRepositoryCrud;

    public List<OfertaModel> generarOferta(List<PersonaDto> idPersonas) {

        if (CollectionUtils.isEmpty(idPersonas)) {
            throw new IllegalArgumentException("lista de idPersonas nulo ");
        }


        return idPersonas.stream()
                .flatMap(persona -> {
                    List<ContratoDto> contratos = this.contratoRepositoryCrud.buscarContratosPorPersona(persona.getIdPersona());
                    return contratos.stream()
                            .filter(contrato -> contrato.getFechaFinReal() == null
                                    || contrato.getFechaFin().isAfter(contrato.getFechaFinReal())
                                    || contrato.getFechaFin().equals(contrato.getFechaFinReal()))
                            .map(contrato -> this.guardarOfertaAContratoOferta(persona.getIdPersona(), contratos, contrato));
                })
                .collect(Collectors.toList());

    }


    public List<ContratoDto> contratosEnBuenosTerminos(List<ContratoDto> contratos) {
        return contratos.stream()
                .filter(contrato -> contrato.getFechaFinReal() == null
                        || contrato.getFechaFin().isAfter(contrato.getFechaFinReal())
                        || contrato.getFechaFin().equals(contrato.getFechaFinReal()))
                .collect(Collectors.toList());
    }

    public String asignacionDePerfil(int cantidadContratos) {

        if (Objects.equals(cantidadContratos, 0)) {
            return propertiesValues.getBueno();
        }
        if (cantidadContratos > 0 && cantidadContratos < 3) {
            return propertiesValues.getBueno();
        }
        if (cantidadContratos >= 3 && cantidadContratos <= 5) {
            return propertiesValues.getExcelente();
        }
        if (cantidadContratos > 5) {
            return propertiesValues.getPlus();
        }
        if (cantidadContratos < 0) {
            throw new IllegalArgumentException("valor fuera de rango");
        }

        throw new IllegalArgumentException("perfil no asignado, candidaContrato no tiene valor");

    }

    public OfertaDto asignacionDeOferta(String perfilamiento) {


        if (Objects.equals(perfilamiento, "bueno")) {
            int mesAsignado = 90;
            OfertaDto ofertas = this.OfertaRepositoryCrud.buscarOfertas(mesAsignado);
            return ofertas;
        }

        if (Objects.equals(perfilamiento, "excelente")) {
            int mesAsignado= 60;
            OfertaDto ofertas = this.OfertaRepositoryCrud.buscarOfertas(mesAsignado);
            return ofertas;
        }
        if (Objects.equals(perfilamiento, "plus")) {
            int mesAsignado = 30;
            OfertaDto oferta = this.OfertaRepositoryCrud.buscarOfertas(mesAsignado);
            return oferta;
        }
        throw new IllegalArgumentException("oferta no asignada");

    }

    public OfertaModel guardarOfertaAContratoOferta(Integer personaId, List<ContratoDto> contratos, ContratoDto contrato) {

        List<ContratoDto> contratoDtoList = this.contratosEnBuenosTerminos(contratos);
        System.out.println("Lista filtrada de contratos:" + contratoDtoList);

        int cantidadDeContratosPorPersona = contratoDtoList.size();
        System.out.println("cantidad de contratos:" + cantidadDeContratosPorPersona);

        String perifl = this.asignacionDePerfil(cantidadDeContratosPorPersona);

        CatPerfilDto perfilDto = this.catPerfilRepositoryCrud.buscarTipoDePerfil(perifl);
        System.out.println("Perfil:" + perfilDto);

        OfertaDto ofertaDto = this.asignacionDeOferta(perifl);
        System.out.println("oferta:" + ofertaDto);
        OfertaDto oferta = this.contratoOfertaRepositoryCrud.ingregarContratoOferta(ofertaDto, perfilDto, contrato);

        OfertaModel ofertaModel = new OfertaModel(personaId, perifl,oferta , contratoDtoList);
        return ofertaModel;
    }


}
