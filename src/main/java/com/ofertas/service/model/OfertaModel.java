package com.ofertas.service.model;

import com.ofertas.service.dto.ContratoDto;
import com.ofertas.service.dto.OfertaDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class OfertaModel {
    private Integer idPersona;
    private String perfil;
    private OfertaDto ofertaDtos;
    private List<ContratoDto> contratosDto;

}
