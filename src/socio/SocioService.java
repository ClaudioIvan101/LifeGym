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

    public Socio buscarSocio(int dni) {
        for (Socio s : listaSocios) {
            if (s.getDni() == dni) {
                return s;
            }
        }
        return null;
    }

    public boolean eliminarSocio(int dni) {
        Socio encontrado = buscarSocio(dni);
        if (encontrado != null) {
            listaSocios.remove(encontrado);
            return true;
        }
        return false;
    }

    public ArrayList<Socio> obtenerTodos() {
        return listaSocios;
    }
}
