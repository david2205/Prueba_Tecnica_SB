package com.seguros.polizasapi.controller;

import com.seguros.polizasapi.dto.RiesgoRequest;
import com.seguros.polizasapi.model.EstadoPoliza;
import com.seguros.polizasapi.model.Poliza;
import com.seguros.polizasapi.model.Riesgo;
import com.seguros.polizasapi.model.TipoPoliza;
import com.seguros.polizasapi.service.PolizaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/polizas")
public class PolizaController {

    private final PolizaService service;

    public PolizaController(PolizaService service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public List<Poliza> listar(@RequestParam(required = false) TipoPoliza tipo,
                              @RequestParam(required = false) EstadoPoliza estado) {
        return service.listar(tipo, estado);
    }

    @GetMapping("/{id}/riesgos")
    public List<Riesgo> obtenerRiesgos(@PathVariable Long id) {
        return service.obtenerRiesgos(id);
    }

    @PostMapping("/{id}/renovar")
    public Poliza renovar(@PathVariable Long id, @RequestParam BigDecimal ipc) {
        return service.renovar(id, ipc);
    }

    @PostMapping("/{id}/cancelar")
    public Poliza cancelar(@PathVariable Long id) {
        return service.cancelar(id);
    }

    @PostMapping("/{id}/riesgos")
    public Riesgo agregarRiesgo(@PathVariable Long id, @RequestBody RiesgoRequest request) {
        return service.agregarRiesgo(id, request);
    }
}
