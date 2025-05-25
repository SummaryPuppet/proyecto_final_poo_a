package pe.edu.utp.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        this.reservas = new ArrayList<>();
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

        mostrarHabitacionesDisponibles();

        System.out.print("Ingrese el número de habitación que desea reservar: ");
        String numeroHabitacion = scanner.nextLine();

        Habitacion habitacionSeleccionada = null;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numeroHabitacion)) {
                habitacionSeleccionada = habitacion;
                break;
            }
        }

        Reserva reserva = Reserva.crearReserva(cliente, habitacionSeleccionada);

        // Si la habitación está ocupada o no existe
        if (reserva != null) {
            if (hayConflictoReserva(habitacionSeleccionada, reserva.getFechaInicio(), reserva.getFechaFin())) {
                System.out.println("Error: ya existe una reserva para esa habitación en ese horario.");
            } else {
                reservas.add(reserva);
                assert habitacionSeleccionada != null;
                habitacionSeleccionada.reservar(); // marca como ocupada
                reserva.confirmarReserva();
                System.out.println("Cliente registrado exitosamente: " + cliente.getNombre());
            }
        }
    }

    public void asignarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado registrado: " + empleado.nombre);
    }

    public void verReservasActivas() {
        if (reservas == null || reservas.isEmpty()) {
            System.out.println("No hay reservas activas.");
            return;
        }

        System.out.println("\nReservas activas:");
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getCliente().getNombre());
            System.out.println("Habitación: " + reserva.getHabitacion().getNumero());
            System.out.println("Desde: " + reserva.getFechaInicio());
            System.out.println("Hasta: " + reserva.getFechaFin());
            System.out.println("------------------------");
        }
    }

    public boolean hayConflictoReserva(Habitacion habitacion, LocalDateTime inicio, LocalDateTime fin) {
        for (Reserva r : reservas) {
            if (r.getHabitacion().equals(habitacion)) {
                // Verificar si se traslapan las fechas
                boolean traslape = !fin.isBefore(r.getFechaInicio()) && !inicio.isAfter(r.getFechaFin());
                if (traslape) {
                    return true;
                }
            }
        }
        return false;
    }

}
