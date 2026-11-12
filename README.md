# COCAST | Seguimiento de Cultivos de Coca en Colombia

Aplicación web desarrollada en **Java y Spring Boot** siguiendo el marco de trabajo **Scrum** y el flujo colaborativo de **GitHub Projects**.

## Objetivo del Producto (Product Goal)
Ayudar a las personas, investigadores y ciudadanos a consultar y hacer seguimiento a la evolución histórica de los cultivos de coca en los municipios de Colombia mediante búsquedas claras por departamento, municipio y periodo.

## Fuente de Datos
- **Origen:** Portal Nacional de Datos Abiertos de Colombia (`datos.gov.co`).
- **Archivo integrado:** `src/main/resources/cultivos_coca.csv` (registros municipales con histórico de hectáreas desde 2001 hasta 2024).

## Tecnologías Utilizadas
- Java (JDK 23)
- Spring Boot (Spring Web + Thymeleaf)
- Bootstrap 5
- Maven

## Cómo ejecutar el proyecto localmente

1. Clona este repositorio en tu equipo:
   ```bash
   git clone [https://github.com/xStebaan/COCAST.git](https://github.com/xStebaan/COCAST.git)
   cd COCAST

## Inicia el servidor local con Maven Wrapper:

sh mvnw spring-boot:run

## Abre tu navegador e ingresa a:

http://localhost:8080

## Funcionalidades entregadas (Sprint 1)

Listado general (#1): Visualización de departamentos, municipios y hectáreas registradas en 2023 y 2024.

Filtro por municipio (#2): Búsqueda por nombre de municipio (insensible a mayúsculas/minúsculas) con mensaje informativo cuando no existen coincidencias.

## Próximos pasos (Product Backlog - Sprint 2)

Seguimiento histórico (#3): Visualización año por año (2001–2024) de la evolución de hectáreas por municipio.

Filtro por departamento (#4): Consulta agrupada de todos los municipios pertenecientes a un departamento.
