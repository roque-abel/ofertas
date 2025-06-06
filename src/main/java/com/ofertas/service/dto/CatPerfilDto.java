package com.ofertas.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatPerfilDto {
    private Integer id;
    private String tipoDePerfil;
}
