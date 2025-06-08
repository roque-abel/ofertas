package com.ofertas.controller;

import com.ofertas.controller.http.PersonaDtoHttp;
import com.ofertas.controller.mapeoController.MapeoCont;
import com.ofertas.service.Service;
import com.ofertas.service.dto.PersonaDto;
import com.ofertas.service.model.OfertaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller

public class Controller {

    @Autowired
    private Service service;
    @Autowired

    private MapeoCont mapeo;

    @PostMapping("/v1/ofertas/guardar-oferta")
    public ResponseEntity<List<OfertaModel>> guardarOferta(@RequestBody PersonaDtoHttp personaDtoHttp) {
        System.out.println("error controller");
        List<PersonaDto> personasId = this.mapeo.personaHttpToDto(personaDtoHttp.getPersonaHttId());
        List<OfertaModel> ofertaModels = this.service.generarOferta(personasId);
        return ResponseEntity.ok(ofertaModels);
    }

}
