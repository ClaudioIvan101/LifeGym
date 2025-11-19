package Membresia;

import java.util.ArrayList;
import java.util.List;

public class CrudMembresia {
    private final List<Membresia> lista = new ArrayList<>();
    private int nextId = 1;

    public Membresia agregar(String nombre, double precio) {
        Membresia m = new Membresia(nextId++, nombre, precio);
        lista.add(m);
        return m;
    }

    public boolean modificar(int id, String nuevoNombre, double nuevoPrecio) {
        Membresia m = buscarPorId(id);
        if (m == null) return false;
        m.setNombre(nuevoNombre);
        m.setPrecio(nuevoPrecio);
        return true;
    }

    public boolean eliminar(int id) {
        Membresia m = buscarPorId(id);
        if (m == null) return false;
        return lista.remove(m);
    }

    public List<Membresia> listar() {
        return new ArrayList<>(lista);
    }

    public Membresia buscarPorId(int id) {
        for (Membresia m : lista) {
            if (m.getId() == id) return m;
        }
        return null;
    }
}
