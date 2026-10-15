# Plataforma de Gestión de Pólizas — API REST

API REST para la gestión de pólizas de arrendamiento de inmuebles (individuales y colectivas), desarrollada con Spring Boot siguiendo arquitectura hexagonal y buenas prácticas de código limpio.

## Contexto de negocio

El sistema gestiona dos tipos de pólizas:
- **Individual:** el tomador y asegurado es el arrendatario, el beneficiario es el arrendador. Solo admite un riesgo.
- **Colectiva:** orientada a inmobiliarias y administraciones de copropiedades. Admite múltiples riesgos.

Todas las pólizas tienen periodo de vigencia, canon mensual y prima (canon × meses). Las renovaciones ajustan el canon según el IPC.

## Stack tecnológico

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (en memoria)
- Maven

## Estructura del proyecto
