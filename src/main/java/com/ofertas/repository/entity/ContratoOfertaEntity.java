package com.ofertas.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name="contrato-ofertas")
public class ContratoOfertaEntity {
    @JoinColumn(name = "id_contrato")
    @ManyToMany
    private ContratoEntity idContrato;
    @JoinColumn(name = "id_oferta")
    @ManyToMany
    private OfertaEntity idOferta;
    @ManyToOne
    @JoinColumn(name = "id_cat_perfil")
    private CatPerfilEntity idCatPerfil;

}

