package com.ofertas.infrastructure.daoRepository;

import com.ofertas.infrastructure.crud.OfertaRepositoryCrud;
import com.ofertas.infrastructure.entity.OfertaEntity;
import com.ofertas.infrastructure.mapeo.Mapeo;
import com.ofertas.infrastructure.repository.OfertaRepository;
import com.ofertas.service.dto.OfertaDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@AllArgsConstructor
public class DaoRepositoryOferta implements OfertaRepositoryCrud {
    private final OfertaRepository ofertaRepository;
    private final Mapeo mapeo;

    public List<OfertaDto> buscarOfertas(){
        LocalDate primeraFecha= LocalDate.now();
        LocalDate segundaFecha = LocalDate.now().plusDays(90);
        List<OfertaEntity> ofertasEntity = ofertaRepository.findByFechaInicioBetween(primeraFecha,segundaFecha);
      return   this.mapeo.ofertaEntityToDto(ofertasEntity);
    }
}
