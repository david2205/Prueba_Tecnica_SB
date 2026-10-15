package com.seguros.polizasapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CoreService {

    private static final Logger logger = LoggerFactory.getLogger(CoreService.class);

    public void notificarCore(String evento, Long polizaId) {
        logger.info(">>> Enviando evento al CORE: evento={}, polizaId={}", evento, polizaId);
    }
}
