import Asistencia.Asistencia;
import Membresia.Membresia;
import Membresia.MenuMembresia;
import Reportes.MenuReporte;
import Reportes.Reporte;
import socio.Socio;
import Asistencia.CrudAsistencia;
import Asistencia.MenuAsistencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MenuMembresia menuMembresia = new MenuMembresia();
        List<Socio> socios = new ArrayList<>();
        List<Asistencia> asistencias = new ArrayList<>();
        List<Membresia> membresias = new ArrayList<>();
        Reporte reporte = new Reporte(socios, asistencias);
        MenuReporte menuReportes = new MenuReporte(reporte);

        CrudAsistencia crudAsistencia =
                new CrudAsistencia(socios, membresias, asistencias, sc);

        MenuAsistencia menuAsistencia =
                new MenuAsistencia(crudAsistencia, sc);
        int opcion;
        do {
            System.out.println("===== SISTEMA DE GESTIÓN DE GIMNASIO =====");
            System.out.println("1. Gestión de Socios");
            System.out.println("2. Gestión de Membresías");
            System.out.println("3. Registrar Asistencia");
            System.out.println("4. Reportes");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            opcion = Integer.parseInt(sc.nextLine().trim());

            switch (opcion) {
                case 1:
                    System.out.println("Menu Socios");
                    break;
                case 2:
                    menuMembresia.mostrarMenuMembresia();
                    break;
                case 3:
                    menuAsistencia.mostrarMenu();
                    break;
                case 4:
                    menuReportes.mostrarMenuReportes();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 5);

        sc.close();
    }
}