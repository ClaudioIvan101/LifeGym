package socio; // <--- IMPORTANTE

import membresia.Membresia;
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
        System.out.print("DNI: "); String dni = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Nro Socio: "); int nro = Integer.parseInt(scanner.nextLine());

        System.out.println("Plan: 1.Diario 2.Semanal 3.Mensual");
        int p = Integer.parseInt(scanner.nextLine());
        Membresia m = (p==2)? Membresia.SEMANAL : (p==3)? Membresia.MENSUAL : Membresia.DIARIO;

        Socio nuevo = new Socio(nombre, dni, email, nro, m);
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
        if(s != null) {
            System.out.println("Cambiar plan a: 1.Diario 2.Semanal 3.Mensual");
            int p = Integer.parseInt(scanner.nextLine());
            Membresia m = (p==2)? Membresia.SEMANAL : (p==3)? Membresia.MENSUAL : Membresia.DIARIO;
            s.setMembresia(m);
            System.out.println(">> Plan actualizado.");
        } else System.out.println("No existe.");
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