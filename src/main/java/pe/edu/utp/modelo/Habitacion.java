package pe.edu.utp.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
    private String numero;
    private String tipo;
    private double precio;
    private boolean ocupada;

    public Habitacion(String numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.ocupada = false;
    }

    public void reservar() {
        if (!ocupada) {
            ocupada = true;
            System.out.println("La habitación " + numero + " ha sido reservada.");
        } else {
            System.out.println("La habitación " + numero + " ya está ocupada.");
        }
    }

    public void liberar() {
        if (ocupada) {
            ocupada = false;
            System.out.println("La habitación " + numero + " ha sido liberada.");
        } else {
            System.out.println("La habitación " + numero + " ya está libre.");
        }
    }

    public void mostrarDetalles() {
        System.out.println("Número: " + numero);
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio: " + precio);
        System.out.println("Estado: " + (ocupada ? "Ocupada" : "Libre"));
    }
}
