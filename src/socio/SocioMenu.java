package socio; // <--- IMPORTANTE

import Membresia.Membresia;

import java.util.Scanner;

public class SocioMenu {

    private SocioService servicio;
    private Scanner scanner;

    public SocioMenu() {
        this.servicio = new SocioService();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

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
                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
            }

        } while (opcion != 0);
    }

    private void agregar() {
        System.out.println("--- ALTA DE SOCIO ---");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("DNI: ");
        int dni = Integer.parseInt(scanner.nextLine());

        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        Socio nuevo = new Socio(dni, nombre, edad);
        servicio.agregarSocio(nuevo);

        System.out.println(">> Socio guardado.");
    }


    private void buscar() {
        System.out.print("Ingrese DNI del socio: ");
        int dni = Integer.parseInt(scanner.nextLine());

        Socio s = servicio.buscarSocio(dni);

        if (s != null) s.mostrarInfo();
        else System.out.println(">> No encontrado.");
    }


    private void modificar() {
        System.out.print("DNI del socio a modificar: ");
        int dni = Integer.parseInt(scanner.nextLine());

        Socio s = servicio.buscarSocio(dni);

        if (s == null) {
            System.out.println(">> No encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (actual: " + s.getNombre() + "): ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nueva edad (actual: " + s.getEdad() + "): ");
        int nuevaEdad = Integer.parseInt(scanner.nextLine());

        s.setNombre(nuevoNombre);
        s.setEdad(nuevaEdad);

        System.out.println(">> Datos modificados.");
    }


    private void eliminar() {
        System.out.print("DNI del socio a eliminar: ");
        int dni = Integer.parseInt(scanner.nextLine());

        if (servicio.eliminarSocio(dni))
            System.out.println(">> Eliminado.");
        else
            System.out.println(">> No encontrado.");
    }


    private void listar() {
        System.out.println("--- LISTADO DE SOCIOS ---");
        if (servicio.obtenerTodos().isEmpty()) {
            System.out.println("No hay socios cargados.");
            return;
        }

        servicio.obtenerTodos().forEach(Socio::mostrarInfo);
    }
}
