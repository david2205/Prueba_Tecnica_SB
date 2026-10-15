package com.seguros.polizasapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "riesgos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Riesgo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String direccionInmueble;
    private BigDecimal valorAsegurado;
    private boolean cancelado = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poliza_id")
    @JsonIgnore
    private Poliza poliza;
}
