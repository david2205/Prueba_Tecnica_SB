-- Póliza individual vigente
INSERT INTO polizas (id, tipo, estado, numero_poliza, fecha_inicio_vigencia, fecha_fin_vigencia, meses_vigencia, canon_mensual, prima, ipc_aplicado)
VALUES (1, 'INDIVIDUAL', 'VIGENTE', 'POL-IND-001', '2025-01-01', '2026-01-01', 12, 1500000, 18000000, 0);

-- Póliza colectiva vigente
INSERT INTO polizas (id, tipo, estado, numero_poliza, fecha_inicio_vigencia, fecha_fin_vigencia, meses_vigencia, canon_mensual, prima, ipc_aplicado)
VALUES (2, 'COLECTIVA', 'VIGENTE', 'POL-COL-001', '2025-03-01', '2026-03-01', 12, 2000000, 24000000, 0);

-- Póliza individual cancelada (para probar que no se puede renovar)
INSERT INTO polizas (id, tipo, estado, numero_poliza, fecha_inicio_vigencia, fecha_fin_vigencia, meses_vigencia, canon_mensual, prima, ipc_aplicado)
VALUES (3, 'INDIVIDUAL', 'CANCELADA', 'POL-IND-002', '2024-06-01', '2025-06-01', 12, 1200000, 14400000, 0);

-- Riesgo para póliza individual
INSERT INTO riesgos (id, poliza_id, descripcion, direccion_inmueble, valor_asegurado, cancelado)
VALUES (1, 1, 'Apartamento 201 Torre A', 'Calle 100 #15-20, Bogotá', 250000000, false);

-- Riesgos para póliza colectiva
INSERT INTO riesgos (id, poliza_id, descripcion, direccion_inmueble, valor_asegurado, cancelado)
VALUES (2, 2, 'Local comercial 101', 'Cra 7 #45-12, Bogotá', 180000000, false);

INSERT INTO riesgos (id, poliza_id, descripcion, direccion_inmueble, valor_asegurado, cancelado)
VALUES (3, 2, 'Oficina 502', 'Av 19 #98-03, Bogotá', 320000000, false);

INSERT INTO riesgos (id, poliza_id, descripcion, direccion_inmueble, valor_asegurado, cancelado)
VALUES (4, 2, 'Bodega sur', 'Autopista Sur Km 5, Bogotá', 450000000, false);

-- Continuar los IDs autogenerados después de los datos iniciales.
ALTER TABLE polizas ALTER COLUMN id RESTART WITH 4;
ALTER TABLE riesgos ALTER COLUMN id RESTART WITH 5;
