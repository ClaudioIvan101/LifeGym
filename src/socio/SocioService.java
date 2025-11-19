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

        }
        return null;
    }

    public boolean eliminarSocio(int nroSocio) {
        return false;
    }

    public ArrayList<Socio> obtenerTodos() {
        return listaSocios;
    }
}