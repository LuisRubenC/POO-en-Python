public class ProfesorTiempoCompleto extends Persona implements Pagable {
    private double salarioMensual;

    public ProfesorTiempoCompleto(String nombre, int id, double salarioMensual) {
        super(nombre, id);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularPago() {
        return salarioMensual;
    }
}
