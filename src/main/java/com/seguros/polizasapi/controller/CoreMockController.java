package com.seguros.polizasapi.controller;

import com.seguros.polizasapi.dto.CoreEventoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/core-mock")
public class CoreMockController {

    private static final Logger logger = LoggerFactory.getLogger(CoreMockController.class);

    @PostMapping("/evento")
    public Map<String, String> recibirEvento(@RequestBody CoreEventoRequest request) {
        logger.info("Evento recibido en CORE mock: evento={}, polizaId={}",
                request.getEvento(), request.getPolizaId());
        return Map.of("status", "RECIBIDO", "mensaje", "Evento registrado en log");
    }
}
