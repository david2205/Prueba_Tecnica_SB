# Plataforma de Gestión de Pólizas - API REST

API REST para gestionar pólizas de arrendamiento de inmuebles, tanto individuales como colectivas. Está hecha con Spring Boot, organizada por capas y cuidando que el código quede limpio y fácil de mantener.

Corresponde al Módulo 2 (Prueba Técnica Práctica) de la prueba para Desarrollador Senior de Seguros Bolívar.

## Contexto de negocio

El sistema maneja dos tipos de póliza:

- **Individual:** el tomador y asegurado es el arrendatario, y el beneficiario es el arrendador. Acá solo cabe un riesgo.
- **Colectiva:** pensada para inmobiliarias y administraciones de copropiedades. Esta sí admite varios riesgos.

Toda póliza tiene su periodo de vigencia, un canon mensual y una prima, que sale de multiplicar el canon por los meses de vigencia. Cuando se renueva, el canon se ajusta según el IPC.

## Stack tecnológico

- Java 17 (anda también con versiones más nuevas)
- Spring Boot 3.2
- Spring Data JPA
- H2 Database (en memoria)
- Maven

## Estructura del proyecto
