package Reportes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Asistencia.Asistencia;
import Reportes.Reporte;
import socio.Socio;

public class MenuReporte {
    private final Reporte reporte;
    private final Scanner sc = new Scanner(System.in);
    private int opcion = 0;

    public MenuReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public void mostrarMenuReportes() {
        do {
            System.out.println("----- Menu Reportes -----");
            System.out.println("1. Monto total facturado");
            System.out.println("2. Ordenar socios por membresía");
            System.out.println("3. Mostrar asistencias de hoy");
            System.out.println("4. Contar asistencias por socio");
            System.out.println("5. Mostrar todos los socios");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Monto total facturado: $" + reporte.montoTotalFacturado());
                    break;
                case 2:
                    List<Socio> ordenados = reporte.ordenarSociosPorMembresia();
                    System.out.println("Socios ordenados por membresía:");
                    ordenados.forEach(s -> System.out.println(s.getNombre() + " - " + s.getMembresia().getNombre()));
                    break;
                case 3:
                    List<Asistencia> hoy = reporte.asistenciasHoy();
                    System.out.println("Asistencias de hoy (" + LocalDate.now() + "):");
                    hoy.forEach(System.out::println);
                    break;
                case 4:
                    Map<Socio, Long> conteo = reporte.contarAsistenciasPorSocio();
                    System.out.println("Cantidad de asistencias por socio:");
                    conteo.forEach((socio, cant) -> System.out.println(socio.getNombre() + ": " + cant));
                    break;
                case 5:
                    System.out.println("Lista de todos los socios:");
                    reporte.mostrarSocios();
                    break;
                case 6:
                    System.out.println("Saliendo del menú de reportes.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intente de nuevo.");
            }

        } while (opcion != 6);
    }
}
