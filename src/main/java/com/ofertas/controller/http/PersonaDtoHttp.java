package com.ofertas.controller.http;

import com.ofertas.service.dto.PersonaDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class  PersonaDtoHttp {
   private List<PersonaHttpRequest> personaHttId;
}
