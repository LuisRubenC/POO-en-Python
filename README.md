# POO-en-Python
# Sistema de Gestión de Cursos

Este proyecto en Java implementa un sistema de consola para gestionar **estudiantes, profesores y cursos**, permitiendo registrar y consultar información, así como calcular promedios y pagos.

## Funcionalidades

El menú principal ofrece las siguientes opciones:

1. Registrar estudiante  
2. Registrar profesor por horas  
3. Registrar profesor tiempo completo  
4. Registrar curso  
5. Agregar calificación a estudiante  
6. Calcular promedio de estudiante  
7. Calcular salario de profesor  
8. Salir  
9. Mostrar estudiantes  
10. Mostrar profesores  
11. Mostrar cursos  

## Estructura del Proyecto

El código principal se encuentra en la clase `App`, que contiene:

- Listas para almacenar estudiantes, profesores y cursos.
- Métodos para registrar y consultar la información.
- Manejo de excepciones para errores comunes como IDs no encontrados.

### Clases necesarias

El proyecto requiere al menos las siguientes clases externas (debes asegurarte de tenerlas implementadas):

- `Estudiante`  
- `Persona` (probablemente clase padre de profesores)  
- `ProfesorPorHoras` (debe implementar la interfaz `Pagable`)  
- `ProfesorTiempoCompleto` (debe implementar la interfaz `Pagable`)  
- `Clase`  
- `Pagable` (interfaz con método `calcularPago()`)

## Lógica principal

El programa utiliza listas para almacenar la información:

```java
private static List<Estudiante> estudiantes = new ArrayList<>();
private static List<Persona> profesores = new ArrayList<>();
private static List<Clase> cursos = new ArrayList<>();

## Ejecución

Asegúrate de que todas las clases mencionadas estén implementadas correctamente.

EJEMPLO

--- MENÚ DE GESTIÓN DE CURSOS ---
1. Registrar estudiante

Seleccione una opción: 1
Nombre: Ana López
ID: 1001
Estudiante registrado.


2. Compila el proyecto con:

```bash
javac App.java
