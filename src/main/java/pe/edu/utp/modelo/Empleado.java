package pe.edu.utp.modelo;


public class Empleado extends Persona {
    private String idEmpleado;
    private String trabajo;

    public Empleado(String nombre, String dni, String trabajo) {
        super(nombre, dni);
        this.trabajo = trabajo;
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Trabajo: " + trabajo);
    }

    public void verHabitacionesDisponibles(Hotel hotel) {
        hotel.mostrarHabitacionesDisponibles();
    }

    public void liberarHabitacion(Habitacion habitacion) {
        habitacion.liberar();
    }
}
