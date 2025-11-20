package Asistencia;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CrudAsistencia {

    private static int idGenerator = 1;

    private ArrayList<Asistencia> asistencias = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    public boolean registrarAsistencia() {
        int id = idGenerator++;

        //listarsocios()
        Socio socioEncontrado = null;

        while (socioEncontrado == null) {
            System.out.print("Ingrese el DNI del socio: ");
            int busquedaSocio = sc.nextInt();
            sc.nextLine();

            for (Socio s : socios) {
                if (s.getDni() == busquedaSocio) {
                    socioEncontrado = s;
                    break;
                }
            }

            if (socioEncontrado == null) {
                System.out.println("Usuario no encontrado, intente nuevamente.\n");
            }
        }

        Membresia membresiaEncontrada = null;

        //listarmembresias()
        while (membresiaEncontrada == null) {
            System.out.print("Seleccione la membresía por ID: ");
            int busquedaMembresia = sc.nextInt();
            sc.nextLine();

            for (Membresia m : membresias) {
                if (m.getId() == busquedaMembresia) {
                    membresiaEncontrada = m;
                    break;
                }
            }

            if (membresiaEncontrada == null) {
                System.out.println("Membresía no encontrada, intente nuevamente.\n");
            }
        }

        LocalTime horaActual = LocalTime.now();

        Asistencia asistencia = new Asistencia(id, socioencontrado, horaActual, membresiaencontrada);

        asistencias.add(asistencia);

        System.out.println("Asistencia registrada con ID: " + id);

        return true;
    }

    public void listarAsistencias() {
        if (asistencias.isEmpty()) {
            System.out.println("No hay asistencias registradas.");
            return;
        }

        for (Asistencia a : asistencias) {
            System.out.println(a);
        }
    }
}

