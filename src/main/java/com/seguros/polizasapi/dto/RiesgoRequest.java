package com.seguros.polizasapi.dto;


import java.math.BigDecimal;

public class RiesgoRequest {

    private String descripcion;
    private String direccionInmueble;
    private BigDecimal valorAsegurado;

    public RiesgoRequest() {
    }

    public RiesgoRequest(String descripcion, String direccionInmueble, BigDecimal valorAsegurado) {
        this.descripcion = descripcion;
        this.direccionInmueble = direccionInmueble;
        this.valorAsegurado = valorAsegurado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccionInmueble() {
        return direccionInmueble;
    }

    public void setDireccionInmueble(String direccionInmueble) {
        this.direccionInmueble = direccionInmueble;
    }

    public BigDecimal getValorAsegurado() {
        return valorAsegurado;
    }

    public void setValorAsegurado(BigDecimal valorAsegurado) {
        this.valorAsegurado = valorAsegurado;
    }
}
