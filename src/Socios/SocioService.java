package Socios;

import Cuotas.Cuota;
import Membresias.Membresia;
import Membresias.CrudMembresia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class SocioService {
    private final List<Socio> socios;
    private final CrudMembresia crudMembresia;

    public SocioService(List<Socio> socios, CrudMembresia crudMembresia) {
        this.socios = socios;
        this.crudMembresia = crudMembresia;
    }

    public void agregarSocio(Socio socio) {
        socios.add(socio);
    }

    public Socio buscarSocio(int dni) {
        for (Socio s : socios) {
            if (s.getDni() == dni) {
                return s;
            }
        }
        return null;
    }

    public boolean eliminarSocio(int dni) {
        Socio encontrado = buscarSocio(dni);
        if (encontrado != null) {
            socios.remove(encontrado);
            return true;
        }
        return false;
    }

    public List<Socio> obtenerTodos() {
        return socios;
    }

    public List<Socio> buscarPorMembresia(Membresia membresia) {
        List<Socio> socios = new ArrayList<>();
        for (Socio s : socios) {
            if (s.getMembresia().getId() == membresia.getId()) {
                socios.add(s);
            }
        }
        return socios;
    }
    public void generarPrimeraCuota(Socio socio) {
        Cuota cuotaInicial = new Cuota(
                socio,
                socio.getMembresia(),
                LocalDate.now()
        );
        socio.getCuotas().add(cuotaInicial);
    }
}
