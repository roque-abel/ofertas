package com.ofertas.infrastructure.daoRepository;

import com.ofertas.infrastructure.crud.CatPerfilRepositoryCrud;
import com.ofertas.infrastructure.entity.CatPerfilEntity;
import com.ofertas.infrastructure.mapeo.Mapeo;
import com.ofertas.infrastructure.repository.PerfilRepository;
import com.ofertas.service.dto.CatPerfilDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DaoRepositoryPerfil implements CatPerfilRepositoryCrud {
    private final PerfilRepository perfilRepository;
    private final Mapeo mapeo;

    public CatPerfilDto buscarTipoDePerfil(String tipoDePerfil){
        CatPerfilEntity perfil = this.perfilRepository.findByTipoDePerfil(tipoDePerfil);
        return this.mapeo.catPerfilEntityToDo(perfil);
    }
}

