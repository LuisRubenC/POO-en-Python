import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static List<Persona> profesores = new ArrayList<>();
    private static List<Clase> cursos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ DE GESTIÓN DE CURSOS ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar profesor por horas");
            System.out.println("3. Registrar profesor tiempo completo");
            System.out.println("4. Registrar curso");
            System.out.println("5. Agregar calificación a estudiante");
            System.out.println("6. Calcular promedio de estudiante");
            System.out.println("7. Calcular salario de profesor");
            System.out.println("8. Salir");
            System.out.println("9. Mostrar estudiantes");
            System.out.println("10. Mostrar profesores");
            System.out.println("11. Mostrar cursos");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia buffer

            try {
                switch (opcion) {
                    case 1 -> registrarEstudiante();
                    case 2 -> registrarProfesorPorHoras();
                    case 3 -> registrarProfesorTiempoCompleto();
                    case 4 -> registrarCurso();
                    case 5 -> agregarCalificacion();
                    case 6 -> calcularPromedio();
                    case 7 -> calcularPago();
                    case 8 -> System.out.println("Saliendo...");
                    case 9 -> mostrarEstudiantes();
                    case 10 -> mostrarProfesores();
                    case 11 -> mostrarCursos();
                    default -> System.out.println("Opción inválida.");
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 8);
    }

    private static void registrarEstudiante() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        estudiantes.add(new Estudiante(nombre, id));
        System.out.println("Estudiante registrado.");
    }

    private static void registrarProfesorPorHoras() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Horas trabajadas: ");
        int horas = scanner.nextInt();
        System.out.print("Pago por hora: ");
        double pagoHora = scanner.nextDouble();
        profesores.add(new ProfesorPorHoras(nombre, id, horas, pagoHora));
        System.out.println("Profesor por horas registrado.");
    }

    private static void registrarProfesorTiempoCompleto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Salario mensual: ");
        double salario = scanner.nextDouble();
        profesores.add(new ProfesorTiempoCompleto(nombre, id, salario));
        System.out.println("Profesor tiempo completo registrado.");
    }

    private static void registrarCurso() {
        System.out.print("Nombre del curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Profesor asignado: ");
        String profesor = scanner.nextLine();
        cursos.add(new Clase(nombreCurso, profesor));
        System.out.println("Curso registrado.");
    }

    private static void agregarCalificacion() {
        System.out.print("ID del estudiante: ");
        int id = scanner.nextInt();
        Estudiante e = buscarEstudiante(id);
        System.out.print("Calificación: ");
        double calificacion = scanner.nextDouble();
        e.agregarCalificacion(calificacion);
        System.out.println("Calificación agregada.");
    }

    private static void calcularPromedio() {
        System.out.print("ID del estudiante: ");
        int id = scanner.nextInt();
        Estudiante e = buscarEstudiante(id);
        System.out.println("Promedio: " + e.calcularPromedio());
    }

    private static void calcularPago() {
        System.out.print("ID del profesor: ");
        int id = scanner.nextInt();
        for (Persona p : profesores) {
            if (p.getId() == id && p instanceof Pagable pagable) {
                System.out.println("Pago: " + pagable.calcularPago());
                return;
            }
        }
        throw new RuntimeException("Profesor no encontrado o no implementa Pagable.");
    }

    private static Estudiante buscarEstudiante(int id) {
        for (Estudiante e : estudiantes) {
            if (e.getId() == id) return e;
        }
        throw new RuntimeException("Estudiante no encontrado.");
    }

    // NUEVAS FUNCIONES
    private static void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("Estudiantes:");
            for (Estudiante e : estudiantes) {
                System.out.println("ID: " + e.getId() + " - Nombre: " + e.getNombre());
            }
        }
    }

    private static void mostrarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            System.out.println("Profesores:");
            for (Persona p : profesores) {
                System.out.println("ID: " + p.getId() + " - Nombre: " + p.getNombre());
            }
        }
    }

    private static void mostrarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            System.out.println("Cursos:");
            for (Clase c : cursos) {
                System.out.println("Curso: " + c.nombreCurso + " - Profesor: " + c.ProfesorAsignado);
            }
        }
    }
}
