package com.ofertas.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
@Data
@Builder
public class OfertaDto {
    private Integer id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String temporada;
}
