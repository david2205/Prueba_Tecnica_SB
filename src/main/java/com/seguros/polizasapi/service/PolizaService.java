package com.seguros.polizasapi.service;

import com.seguros.polizasapi.dto.RiesgoRequest;
import com.seguros.polizasapi.exception.BusinessException;
import com.seguros.polizasapi.model.EstadoPoliza;
import com.seguros.polizasapi.model.Poliza;
import com.seguros.polizasapi.model.Riesgo;
import com.seguros.polizasapi.model.TipoPoliza;
import com.seguros.polizasapi.repository.PolizaRepository;
import com.seguros.polizasapi.repository.RiesgoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class PolizaService {

    private final PolizaRepository polizaRepository;
    private final RiesgoRepository riesgoRepository;
    private final CoreService coreService;

    public PolizaService(PolizaRepository polizaRepository,
                         RiesgoRepository riesgoRepository,
                         CoreService coreService) {
        this.polizaRepository = polizaRepository;
        this.riesgoRepository = riesgoRepository;
        this.coreService = coreService;
    }

    public List<Poliza> listar(TipoPoliza tipo, EstadoPoliza estado) {
        if (tipo != null && estado != null) {
            return polizaRepository.findByTipoAndEstado(tipo, estado);
        }
        if (tipo != null) {
            return polizaRepository.findByTipo(tipo);
        }
        if (estado != null) {
            return polizaRepository.findByEstado(estado);
        }
        return polizaRepository.findAll();
    }

    public List<Riesgo> obtenerRiesgos(Long polizaId) {
        Poliza poliza = buscarPoliza(polizaId);
        return poliza.getRiesgos().stream()
                .filter(riesgo -> !riesgo.isCancelado())
                .toList();
    }

    public Poliza renovar(Long id, BigDecimal ipc) {
        Poliza poliza = buscarPoliza(id);
        if (poliza.getEstado() == EstadoPoliza.CANCELADA) {
            throw new BusinessException("No se puede renovar una póliza cancelada");
        }

        BigDecimal nuevoCanon = poliza.getCanonMensual()
                .multiply(BigDecimal.ONE.add(ipc.movePointLeft(2)));
        poliza.setCanonMensual(nuevoCanon);
        poliza.setPrima(nuevoCanon.multiply(BigDecimal.valueOf(poliza.getMesesVigencia())));
        poliza.setIpcAplicado(ipc);
        poliza.setFechaInicioVigencia(poliza.getFechaFinVigencia());
        poliza.setFechaFinVigencia(poliza.getFechaInicioVigencia()
                .plusMonths(poliza.getMesesVigencia()));
        poliza.setEstado(EstadoPoliza.RENOVADA);

        coreService.notificarCore("ACTUALIZACION", id);
        return polizaRepository.save(poliza);
    }

    public Poliza cancelar(Long id) {
        Poliza poliza = buscarPoliza(id);
        poliza.setEstado(EstadoPoliza.CANCELADA);
        poliza.getRiesgos().forEach(riesgo -> riesgo.setCancelado(true));

        coreService.notificarCore("CANCELACION", id);
        return polizaRepository.save(poliza);
    }

    public Riesgo agregarRiesgo(Long polizaId, RiesgoRequest request) {
        Poliza poliza = buscarPoliza(polizaId);
        if (poliza.getTipo() == TipoPoliza.INDIVIDUAL) {
            throw new BusinessException("No se pueden agregar riesgos a una póliza individual");
        }

        Riesgo riesgo = new Riesgo();
        riesgo.setDescripcion(request.getDescripcion());
        riesgo.setDireccionInmueble(request.getDireccionInmueble());
        riesgo.setValorAsegurado(request.getValorAsegurado());
        riesgo.setPoliza(poliza);
        riesgo.setCancelado(false);
        poliza.getRiesgos().add(riesgo);

        coreService.notificarCore("ACTUALIZACION", polizaId);
        return riesgoRepository.save(riesgo);
    }

    public Riesgo cancelarRiesgo(Long riesgoId) {
        Riesgo riesgo = riesgoRepository.findById(riesgoId)
                .orElseThrow(() -> new BusinessException("Riesgo no encontrado"));
        riesgo.setCancelado(true);

        coreService.notificarCore("ACTUALIZACION", riesgo.getPoliza().getId());
        return riesgoRepository.save(riesgo);
    }

    private Poliza buscarPoliza(Long id) {
        return polizaRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Póliza no encontrada"));
    }
}
