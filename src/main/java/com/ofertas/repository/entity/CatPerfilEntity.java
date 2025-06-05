package com.ofertas.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "cat-perfiles")
public class CatPerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="tipo_de_perfil")
    private String tipoDePerfil;
}
