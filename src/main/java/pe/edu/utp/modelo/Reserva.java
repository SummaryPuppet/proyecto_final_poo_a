package pe.edu.utp.modelo;

import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

@Getter
@Setter
public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public static Reserva crearReserva(Cliente cliente, Habitacion habitacion) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            System.out.print("Ingrese la fecha y hora de inicio (yyyy-MM-dd HH:mm): ");

            String inicioStr = scanner.nextLine();
            ;

            LocalDateTime inicio = LocalDateTime.parse(inicioStr, formatter);


            System.out.print("Ingrese la fecha y hora de fin (yyyy-MM-dd HH:mm): ");
            String finStr = scanner.nextLine();
            LocalDateTime fin = LocalDateTime.parse(finStr, formatter);

            return new Reserva(cliente, habitacion, inicio, fin);
        } catch (DateTimeParseException e) {
            ;
            System.out.println("Formato de fecha incorrecto.");

            return null;
        }
    }

    public void confirmarReserva() {
        System.out.println("Reserva confirmada desde " + this.fechaInicio + " hasta " + this.fechaFin +
                " para la habitación " + habitacion.getNumero());
    }

    public void cancelarReserva() {
        System.out.println("Reserva cancelada para la habitación " + habitacion.getNumero());
    }
}
