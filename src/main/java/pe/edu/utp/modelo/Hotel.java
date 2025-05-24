package pe.edu.utp.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Empleado> empleados;
    private  List<Reserva> reservas;

    public Hotel(String nombre, List<Habitacion> habitaciones, List<Empleado> empleados) {
        this.nombre = nombre;
        this.habitaciones = habitaciones;
        this.empleados = empleados;
    }

    public void mostrarHabitacionesDisponibles() {
        System.out.println("\nHabitaciones disponibles:");
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.isOcupada()) {
                habitacion.mostrarDetalles();
                System.out.println();
            }
        }
    }

    public void registrarCliente(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar habitaciones disponibles
        mostrarHabitacionesDisponibles();

        System.out.print("Ingrese el número de habitación que desea reservar: ");
        String numeroHabitacion = scanner.nextLine();

        // Buscar habitación por número
        Habitacion habitacionSeleccionada = null;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numeroHabitacion)) {
                habitacionSeleccionada = habitacion;
                break;
            }
        }

        // Si la habitación está ocupada o no existe
        if (habitacionSeleccionada == null || habitacionSeleccionada.isOcupada()) {
            System.out.println("La habitación seleccionada está ocupada o no existe.");
        } else {
            habitacionSeleccionada.reservar();
            System.out.println("Cliente registrado exitosamente: " + cliente.nombre);
        }
    }

    // Asignar un empleado
    public void asignarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado registrado: " + empleado.nombre);
    }
}
