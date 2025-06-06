package com.ofertas.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class PersonaDto {
    private Integer idPersona;

    public PersonaDto(Integer idPersona) {
        this.idPersona = idPersona;
    }
}
