package pe.edu.utp.modelo;

import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Getter
@Setter
public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private Date fechaInicio;
    private Date fechaFin;

    public Reserva(Cliente cliente, Habitacion habitacion, Date fechaInicio, Date fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public static Reserva crearReserva(Cliente cliente, Habitacion habitacion) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la fecha de inicio de la reserva (en formato yyyy-mm-dd): ");
        String fechaInicioStr = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin de la reserva (en formato yyyy-mm-dd): ");
        String fechaFinStr = scanner.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaInicio = new Date();
        Date fechaFin = new Date();

        try {
            fechaInicio = formatter.parse(fechaInicioStr);
            fechaFin = formatter.parse(fechaFinStr);
            System.out.println("Se registro con la fecha");
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }

        return new Reserva(cliente, habitacion, fechaInicio, fechaFin);
    }

    public void confirmarReserva() {
        System.out.println("Reserva confirmada para la habitación " + habitacion.getNumero());
    }

    public void cancelarReserva() {
        System.out.println("Reserva cancelada para la habitación " + habitacion.getNumero());
    }
}
