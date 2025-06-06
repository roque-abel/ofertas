package com.ofertas.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ContratoDto {

    private Integer id;

    private Integer idPersona;

    private  String nombre;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private LocalDate fechaFinReal;

}
