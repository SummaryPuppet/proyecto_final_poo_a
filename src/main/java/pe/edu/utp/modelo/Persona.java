package pe.edu.utp.modelo;

import lombok.*;

@Getter
@Setter
public class Persona {
    protected String nombre;
    protected String dni;

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento de Identidad: " + dni);
    }
}
