package com.ofertas.infrastructure.daoRepository;

import com.ofertas.infrastructure.crud.ContratoRepositoryCrud;
import com.ofertas.infrastructure.entity.ContratoEntity;
import com.ofertas.infrastructure.mapeo.Mapeo;
import com.ofertas.infrastructure.repository.ContratoRepository;
import com.ofertas.service.dto.ContratoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DaoRepositoryContrato implements ContratoRepositoryCrud {
    @Autowired
    private  ContratoRepository contratoRepository;
    @Autowired
    private Mapeo mapeo;

    @Override
    public List<ContratoDto> buscarContratosPorPersona(Integer idPersonas) {
        List<ContratoEntity> contratosPorPersona = this.contratoRepository.findByidPersona(idPersonas);
        return this.mapeo.listContratoEntityToDto(contratosPorPersona);
    }
}
