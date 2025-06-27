import java.util.List;
import java.util.ArrayList;

public class Estudiante extends Persona implements Calificable {
    private List<Double> calificaciones;

    public Estudiante(String nombre, int id) {
        super(nombre, id);
        this.calificaciones = new ArrayList<>();
    }

    public void agregarCalificacion(double calificacion) {
        calificaciones.add(calificacion);
    }

    @Override
    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            throw new RuntimeException("No hay calificaciones registradas.");
        }
        double suma = 0;
        for (double c : calificaciones) {
            suma += c;
        }
        return suma / calificaciones.size();
    }
}
