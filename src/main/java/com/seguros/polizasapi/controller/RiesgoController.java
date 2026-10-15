package com.seguros.polizasapi.controller;

import com.seguros.polizasapi.model.Riesgo;
import com.seguros.polizasapi.service.PolizaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/riesgos")
public class RiesgoController {

    private final PolizaService service;

    public RiesgoController(PolizaService service) {
        this.service = service;
    }

    @PostMapping("/{id}/cancelar")
    public Riesgo cancelarRiesgo(@PathVariable Long id) {
        return service.cancelarRiesgo(id);
    }
}
