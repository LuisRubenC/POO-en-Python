public class ProfesorPorHoras extends Persona implements Pagable {
    private int horasTrabajadas;
    private double pagoPorHora;

    public ProfesorPorHoras(String nombre, int id, int horasTrabajadas, double pagoPorHora) {
        super(nombre, id);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }

    @Override
    public double calcularPago() {
        return horasTrabajadas * pagoPorHora;
    }
}
