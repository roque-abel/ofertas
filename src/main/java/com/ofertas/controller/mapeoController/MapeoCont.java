package com.ofertas.controller.mapeoController;

import com.ofertas.controller.http.PersonaDtoHttp;
import com.ofertas.controller.http.PersonaHttpRequest;
import com.ofertas.service.dto.PersonaDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class MapeoCont {

public List<PersonaDto> personaHttpToDto( List<PersonaHttpRequest> personaDtoHttp){

    List<PersonaDto>  personaDtos = personaDtoHttp.stream()
            .map(personaHttp ->{
                PersonaDto personasDto = new PersonaDto( personaHttp.getPersonaId());
                return personasDto;
            }).collect(Collectors.toList());
    return personaDtos;
}

}
