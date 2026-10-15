package com.seguros.polizasapi.repository;

import com.seguros.polizasapi.model.EstadoPoliza;
import com.seguros.polizasapi.model.Poliza;
import com.seguros.polizasapi.model.TipoPoliza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolizaRepository extends JpaRepository<Poliza, Long> {

    List<Poliza> findByTipo(TipoPoliza tipo);

    List<Poliza> findByEstado(EstadoPoliza estado);

    List<Poliza> findByTipoAndEstado(TipoPoliza tipo, EstadoPoliza estado);
}
