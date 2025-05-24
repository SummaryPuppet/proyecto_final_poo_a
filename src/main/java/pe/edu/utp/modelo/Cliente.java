package pe.edu.utp.modelo;


import java.util.Scanner;

public class Cliente extends Persona {
    public Cliente(String nombre, String dni) {
        super(nombre, dni);
    }

    public static Cliente crearCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el documento de identidad: ");
        String documentoIdentidad = scanner.nextLine();

        return new Cliente(nombre, documentoIdentidad);
    }
}
