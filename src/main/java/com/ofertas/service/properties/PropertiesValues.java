package com.ofertas.service.properties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PropertiesValues {

    @Value("${perfil.malo}")
    private String malo;

    @Value("${perfil.bueno")
    private String bueno;

    @Value("${perfil.excelente")
    private String excelente;

    @Value("${perfil.plus")
    private String plus;

    public PropertiesValues(String malo, String bueno, String excelente, String plus) {
        this.malo = malo;
        this.bueno = bueno;
        this.excelente = excelente;
        this.plus = plus;
    }
}
