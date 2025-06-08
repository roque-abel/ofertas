package com.ofertas.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="contrato_ofertas")
public class ContratoOfertaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oferta")
    private OfertaEntity idOferta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cat_perfil")
    private CatPerfilEntity idCatPerfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contrato")
    private ContratoEntity idContrato;
}

