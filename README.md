# POO-en-Python
#  Sistema de Gestión de Cursos

Este proyecto en Java implementa un sistema de consola para gestionar **estudiantes, profesores y cursos**, permitiendo registrar y consultar información, así como calcular promedios y pagos.


##  Funcionalidades principales

- Registrar estudiantes con nombre e ID.
- Registrar profesores por horas o tiempo completo.
- Registrar cursos vinculados a un profesor.
- Agregar calificaciones a estudiantes.
- Calcular promedio de calificaciones.
- Calcular salario de profesores.
- Visualizar información almacenada.

##  Lógica principal

El programa utiliza listas para almacenar la información:

```java
private static List<Estudiante> estudiantes = new ArrayList<>();
private static List<Persona> profesores = new ArrayList<>();
private static List<Clase> cursos = new ArrayList<>();
```

Y presenta un menú para la interacción:

```java
System.out.println("1. Registrar estudiante");
System.out.println("2. Registrar profesor por horas");
System.out.println("3. Registrar profesor tiempo completo");
// ...
System.out.print("Seleccione una opción: ");
opcion = scanner.nextInt();
```

Las acciones se manejan con un `switch-case` que canaliza la lógica a métodos especializados:

```java
switch (opcion) {
    case 1 -> registrarEstudiante();
    case 2 -> registrarProfesorPorHoras();
// ...
}
```

##  Estructura del código

Algunas funciones clave incluyen:

- Registro de estudiante:

```java
private static void registrarEstudiante() {
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("ID: ");
    int id = scanner.nextInt();
    estudiantes.add(new Estudiante(nombre, id));
}
```

- Agregar calificación:

```java
private static void agregarCalificacion() {
    System.out.print("ID del estudiante: ");
    int id = scanner.nextInt();
    Estudiante e = buscarEstudiante(id);
    System.out.print("Calificación: ");
    double calificacion = scanner.nextDouble();
    e.agregarCalificacion(calificacion);
}
```

- Calcular pago de profesor:

```java
private static void calcularPago() {
    System.out.print("ID del profesor: ");
    int id = scanner.nextInt();
    for (Persona p : profesores) {
        if (p.getId() == id && p instanceof Pagable pagable) {
            System.out.println("Pago: " + pagable.calcularPago());
        }
    }
}
```

##  Requisitos

- JDK 17 o superior.
- Clases requeridas:
  - `Estudiante`: con ID, nombre y lista de calificaciones.
  - `Persona`: clase base.
  - `ProfesorPorHoras`, `ProfesorTiempoCompleto`: clases hijas que implementan la interfaz `Pagable`.
  - `Clase`: contiene nombre de curso y profesor asignado.
  - Interfaz `Pagable`:

```java
public interface Pagable {
    double calcularPago();
}
```

##  Ejecución

Compila y ejecuta con:

```bash
javac App.java
java App
```

## 🔗 Acceso a Microsoft Planner

Gestion de tareas relacionadas [ Microsoft Planner](https://teams.microsoft.com/l/entity/com.microsoft.teamspace.tab.planner/mytasks?tenantId=f94bf4d9-8097-4794-adf6-a5466ca28563&webUrl=https%3A%2F%2Ftasks.teams.microsoft.com%2Fteamsui%2FpersonalApp%2Falltasklists&context=%7B%22subEntityId%22%3A%22%2Fv1%2Fassignedtome%2Fview%2Fboard%2Ftask%2F0Q6uaWP_bkWtrN6szEjiDmQAJy91%22%7D)



