package pe.edu.utp;

import pe.edu.utp.modelo.Cliente;
import pe.edu.utp.modelo.Empleado;
import pe.edu.utp.modelo.Habitacion;
import pe.edu.utp.modelo.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear habitaciones
        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion("101", "Individual", 100.0));
        habitaciones.add(new Habitacion("102", "Doble", 150.0));
        habitaciones.add(new Habitacion("103", "Suite", 250.0));

        // Crear empleados
        List<Empleado> empleados = new ArrayList<>();
        Empleado emp1 = new Empleado("Carlos Pérez", "11122333", "Recepcionista");
        empleados.add(emp1);

        // Crear el hotel
        Hotel hotel = new Hotel("Hotel Paradise", habitaciones, empleados);

        // Menú de interacción
        while (true) {
            System.out.println("\n1. Registrar un cliente");
            System.out.println("2. Mostrar habitaciones disponibles");
            System.out.println("3. Liberar habitación (Empleado)");
            System.out.println("4. Ver información de empleados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (opcion == 1) {
                // Crear cliente
                Cliente cliente = Cliente.crearCliente();
                hotel.registrarCliente(cliente);
            } else if (opcion == 2) {
                // Mostrar habitaciones disponibles
                hotel.mostrarHabitacionesDisponibles();
            } else if (opcion == 3) {
                // Liberar habitación (empleado)
                System.out.print("Ingrese el número de habitación a liberar: ");
                String numeroHabitacion = scanner.nextLine();
                Habitacion habitacionSeleccionada = null;
                for (Habitacion habitacion : habitaciones) {
                    if (habitacion.getNumero().equals(numeroHabitacion)) {
                        habitacionSeleccionada = habitacion;
                        break;
                    }
                }

                if (habitacionSeleccionada != null) {
                    emp1.liberarHabitacion(habitacionSeleccionada);
                } else {
                    System.out.println("La habitación no existe.");
                }
            } else if (opcion == 4) {
                // Ver empleados
                for (Empleado empleado : empleados) {
                    empleado.mostrarInformacion();
                }
            } else if (opcion == 5) {
                // Salir del programa
                System.out.println("¡Gracias por usar el sistema de hotel!");
                break;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}