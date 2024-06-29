# README - Wiki Countries

## Descripción

Esta aplicación Android consume la API de [REST Countries](https://restcountries.com/) para presentar información sobre los países del mundo. Está diseñada para mostrar una lista de países y detalles específicos de cada país seleccionado. La aplicación tiene dos pantallas principales:

1. **Pantalla de Lista de Países**: Muestra una lista de países con su nombre común, nombre oficial y la bandera.
2. **Pantalla de Detalle del País**: Muestra detalles más específicos del país seleccionado, incluyendo nombre común, nombre oficial, capital, continente, descripción de la bandera y el escudo de armas. También permite abrir la ubicación del país en Google Maps.

## Funcionalidades

### Pantalla 1: Lista de Países
- **Consumo de API**: 
  - URL: `https://restcountries.com/v3.1/all?fields=name,flags`
- **Datos a mostrar**:
  - Nombre común del país
  - Nombre oficial del país
  - Imagen de la bandera del país
- **Características adicionales**:
  - Filtro de búsqueda por nombre de país

### Pantalla 2: Detalle del País
- **Consumo de API**:
  - URL: `https://restcountries.com/v3.1/name/{nombre}`
- **Datos a mostrar**:
  - Nombre común del país
  - Nombre oficial del país
  - Capital del país
  - Continente
  - Descripción de la bandera (`alt`)
  - Escudo de armas (`coatOfArms`)
  - Botón para abrir la ubicación del país en Google Maps

## Instalación y Uso

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tuusuario/nombre-repositorio.git
