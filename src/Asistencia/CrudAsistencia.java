package Asistencia;

import Membresia.Membresia;
import socio.Socio;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudAsistencia {

    private static int idGenerator = 1;

    private final List<Asistencia> asistencias;
    private final List<Socio> socios;
    private final List<Membresia> membresias;
    private final Scanner sc;

    public CrudAsistencia(List<Socio> socios,
                          List<Membresia> membresias,
                          List<Asistencia> asistencias,
                          Scanner sc) {

        this.socios = socios;
        this.membresias = membresias;
        this.asistencias = asistencias;
        this.sc = sc;
    }

    public boolean registrarAsistencia() {

        int id = idGenerator++;
        Socio socioEncontrado = null;

        while (socioEncontrado == null) {

            System.out.print("Ingrese el DNI del socio: ");

            int dni = leerEntero();

            for (Socio s : socios) {
                if (s.getDni() == dni) {
                    socioEncontrado = s;
                    break;
                }
            }

            if (socioEncontrado == null) {
                System.out.println("Socio no encontrado. Intente nuevamente.\n");
            }
        }

        Membresia membresiaEncontrada = null;

        while (membresiaEncontrada == null) {

            System.out.println("Membresías disponibles:");
            membresias.forEach(m ->
                    System.out.println("ID " + m.getId() + " - " + m.getNombre())
            );

            System.out.print("Seleccione por ID: ");

            int idM = leerEntero();

            for (Membresia m : membresias) {
                if (m.getId() == idM) {
                    membresiaEncontrada = m;
                    break;
                }
            }

            if (membresiaEncontrada == null) {
                System.out.println("Membresía no encontrada. Intente otra vez.\n");
            }
        }

        LocalDateTime fechaHora = LocalDateTime.now();

        Asistencia asistencia = new Asistencia(
                id,
                socioEncontrado,
                fechaHora,
                membresiaEncontrada
        );

        asistencias.add(asistencia);

        System.out.println("Asistencia registrada! numero" + id);
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

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Intente otra vez: ");
            }
        }
    }
}

