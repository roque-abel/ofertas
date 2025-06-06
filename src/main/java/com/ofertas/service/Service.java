package com.ofertas.service;

import com.ofertas.infrastructure.crud.ContratoRepositoryCrud;
import com.ofertas.service.dto.ContratoDto;
import com.ofertas.service.dto.OfertaDto;
import com.ofertas.service.dto.PersonaDto;
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

    private final com.ofertas.infrastructure.crud.OfertaRepositoryCrud OfertaRepositoryCrud;

    public void obtencionDeOferta(List<PersonaDto> idPersonas) {

        if (CollectionUtils.isEmpty(idPersonas)) {
            throw new IllegalArgumentException("lista de idPersonas nulo ");
        }

        idPersonas.stream()
                .map(persona -> {
                    List<ContratoDto> contratos = this.contratoRepositoryCrud.buscarContratosPorPersona(persona.getIdPersona());
                    List<ContratoDto> contratoDtoList = contratosEnBuenosTerminos(contratos);
                    contratoDtoList.stream()
                            .map(contrato -> {
                                int cantidadDeContratosPorPersona = contratoDtoList.size();
                                String perifl = this.asignacionDePerfil(cantidadDeContratosPorPersona);
                                OfertaDto ofertaDto = asignacionDeOferta(perifl);

                            })


                });


    }

    public static List<ContratoDto> contratosEnBuenosTerminos(List<ContratoDto> contratos) {
        return contratos.stream()

                .filter(contrato -> contrato.getFechaFin().isAfter(contrato.getFechaFinReal()))
                .filter(contrato -> contrato.getFechaFin().equals(contrato.getFechaFinReal()))
                .filter(contrato -> contrato.getFechaFinReal().equals(null))
                .collect(Collectors.toList());
    }

    public String asignacionDePerfil(int cantidadContratos) {

        if (Objects.equals(cantidadContratos, 0)) {
            return propertiesValues.getBueno();
        }
        if (cantidadContratos == 0 || cantidadContratos < 3) {
            return propertiesValues.getBueno();
        }
        if (cantidadContratos >= 3 || cantidadContratos < 5) {
            return propertiesValues.getExcelente();
        }
        if (cantidadContratos > 5) {
            return propertiesValues.getBueno();
        }

        throw new IllegalArgumentException("perfil no asignado, candidaContrato no tiene valor");

    }

    public OfertaDto asignacionDeOferta(String perfilamiento) {

        List<OfertaDto> ofertas = this.OfertaRepositoryCrud.buscarOfertas();

        if (Objects.equals(perfilamiento, "bueno")) {
            OfertaDto ofertaDto = ofertas.get(0);
            return  ofertaDto;
        }

        if (Objects.equals(perfilamiento, "excelente")) {
            OfertaDto ofertaDto = ofertas.get(0);
            return  ofertaDto;
        }
        if (Objects.equals(perfilamiento, "plus")) {
            OfertaDto ofertaDto = ofertas.get(0);
            return  ofertaDto;
        }
        throw new IllegalArgumentException("oferta no asignada");

    }



}
