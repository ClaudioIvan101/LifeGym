package Membresia;

import java.util.List;
import java.util.Scanner;

public class MenuMembresia {
    Scanner sc = new Scanner(System.in);
    int opcion = 0;
    private final CrudMembresia crud = new CrudMembresia();

    void mostrarMenuMembresia() {
        do {
            System.out.println("----- Menu Membresia -----");
            System.out.println("1. Agregar Membresia");
            System.out.println("2. Modificar Membresia");
            System.out.println("3. Eliminar Membresia");
            System.out.println("4. Mostrar Membresias");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    agregarMembresia();
                    break;
                case 2:
                    modificarMembresia();
                    break;
                case 3:
                    eliminarMembresia();
                    break;
                case 4:
                    mostrarMembresias();
                    break;
                case 5:
                    System.out.println("Saliendo del menu de Membresia.");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void agregarMembresia() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine().trim();
            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Duracion (dias): ");

            Membresia m = crud.agregar(nombre, precio);
            System.out.println("Membresia agregada: " + m);
        } catch (NumberFormatException e) {
            System.out.println("Datos invalidos. Operacion cancelada.");
        }
    }

    private void modificarMembresia() {
        try {
            System.out.print("Ingrese ID de la membresia a modificar: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Membresia existente = crud.buscarPorId(id);
            if (existente == null) {
                System.out.println("Membresia no encontrada.");
                return;
            }
            System.out.println("Encontrado: " + existente);
            System.out.print("Nuevo nombre (enter para mantener): ");
            String nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) nombre = existente.getNombre();

            System.out.print("Nuevo precio (enter para mantener): ");
            String precioStr = sc.nextLine().trim();
            double precio = precioStr.isEmpty() ? existente.getPrecio() : Double.parseDouble(precioStr);

            System.out.print("Nueva duracion dias (enter para mantener): ");

            boolean ok = crud.modificar(id, nombre, precio);
            System.out.println(ok ? "Membresia modificada." : "No se pudo modificar.");
        } catch (NumberFormatException e) {
            System.out.println("Datos invalidos. Operacion cancelada.");
        }
    }

    private void eliminarMembresia() {
        try {
            System.out.print("Ingrese ID de la membresia a eliminar: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            boolean ok = crud.eliminar(id);
            System.out.println(ok ? "Membresia eliminada." : "Membresia no encontrada.");
        } catch (NumberFormatException e) {
            System.out.println("ID invalido. Operacion cancelada.");
        }
    }

    private void mostrarMembresias() {
        List<Membresia> lista = crud.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay membresias registradas.");
            return;
        }
        System.out.println("Lista de membresias:");
        for (Membresia m : lista) {
            System.out.println(m);
        }
    }

    public static void main(String[] args) {
        new MenuMembresia().mostrarMenuMembresia();
    }
}

