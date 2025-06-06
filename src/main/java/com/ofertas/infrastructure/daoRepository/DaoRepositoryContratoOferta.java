package com.ofertas.infrastructure.daoRepository;

import com.ofertas.infrastructure.crud.ContratoOfertaRepositoryCrud;
import com.ofertas.infrastructure.repository.ContratoOfertaReporsitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DaoRepositoryContratoOferta implements ContratoOfertaRepositoryCrud {
    private final ContratoOfertaReporsitory contratoOfertaReporsitory;

}
