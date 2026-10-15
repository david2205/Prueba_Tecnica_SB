package com.seguros.polizasapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiesgoRequest {

    private String descripcion;
    private String direccionInmueble;
    private BigDecimal valorAsegurado;
}
