package socio;

import java.util.ArrayList;

public class SocioService {
    private ArrayList<Socio> listaSocios;

    public SocioService() {
        this.listaSocios = new ArrayList<>();
    }

    public void agregarSocio(Socio socio) {
        listaSocios.add(socio);
    }

    public Socio buscarSocio(int nroSocio) {
        for (Socio s : listaSocios) {
            if (s.getNroSocio() == nroSocio) {
                return s;
            }
        }
        return null;
    }

    public boolean eliminarSocio(int nroSocio) {
        // removeIf elimina si se cumple la condición (Lógica funcional)
        return listaSocios.removeIf(s -> s.getNroSocio() == nroSocio);
    }

    public ArrayList<Socio> obtenerTodos() {
        return listaSocios;
    }
}