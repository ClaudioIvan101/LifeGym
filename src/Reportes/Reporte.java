package Reportes;

import Asistencia.Asistencia;
import socio.Socio;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reporte {

        private List<Socio> socios;
        private List<Asistencia> asistencias;

        public Reporte(List<Socio> socios, List<Asistencia> asistencias) {
            this.socios = socios;
            this.asistencias = asistencias;
        }
    public double montoTotalFacturado() {
        return socios.stream()
                .mapToDouble(s -> s.getMembresia().getPrecio())
                .sum();
    }

        public List<Socio> ordenarSociosPorMembresia() {
        return socios.stream()
                .sorted(Comparator.comparing(s -> s.getMembresia().getNombre()))
                .toList();
       }


    public List<Asistencia> asistenciasHoy() {
            LocalDate hoy = LocalDate.now();
            return asistencias.stream()
                    .filter(a -> a.getFechaHora().toLocalDate().equals(hoy))
                    .toList();
        }

        public Map<Socio, Long> contarAsistenciasPorSocio() {
            return asistencias.stream()
                    .collect(Collectors.groupingBy(Asistencia::getSocio, Collectors.counting()));
        }

        public void mostrarSocios() {
            socios.forEach(s -> System.out.println(s.getNombre()));
        }
}
