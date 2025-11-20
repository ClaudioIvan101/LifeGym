package socio; // <--- IMPORTANTE

import Membresia.Membresia;

import java.util.Scanner;

public class SocioMenu {
    private SocioService servicio; // Conecta con el servicio
    private Scanner scanner;

    public SocioMenu() {
        this.servicio = new SocioService();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n=== SUB MENU SOCIOS ===");
            System.out.println("1. Agregar socio");
            System.out.println("2. Buscar socio");
            System.out.println("3. Modificar socio");
            System.out.println("4. Eliminar socio");
            System.out.println("5. Listar socios");
            System.out.println("0. Volver");
            System.out.print("Seleccione opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1: agregar(); break;
                    case 2: buscar(); break;
                    case 3: modificar(); break;
                    case 4: eliminar(); break;
                    case 5: listar(); break;
                    case 0: break;
                    default: System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        } while (opcion != 0);
    }

    // --- MÉTODOS INTERNOS DEL MENÚ ---

    private void agregar() {
        System.out.println("--- ALTA DE SOCIO ---");
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("DNI: "); int dni = scanner.nextInt();
        System.out.println("Edad: "); int edad = Integer.parseInt(scanner.nextLine());
        Socio nuevo = new Socio(dni,nombre, edad);
        servicio.agregarSocio(nuevo);
        System.out.println(">> Guardado.");
    }

    private void buscar() {
        System.out.print("Ingrese Nro Socio: ");
        int nro = Integer.parseInt(scanner.nextLine());
        Socio s = servicio.buscarSocio(nro);
        if(s != null) s.mostrarInfo();
        else System.out.println("No encontrado.");
    }

    private void modificar() {
        System.out.print("Nro Socio a Modificar: ");
        int nro = Integer.parseInt(scanner.nextLine());
        Socio s = servicio.buscarSocio(nro);
    }

    private void eliminar() {
        System.out.print("Nro Socio a Eliminar: ");
        int nro = Integer.parseInt(scanner.nextLine());
        if(servicio.eliminarSocio(nro)) System.out.println(">> Eliminado.");
        else System.out.println("No encontrado.");
    }

    private void listar() {
        servicio.obtenerTodos().forEach(Socio::mostrarInfo);
    }
}