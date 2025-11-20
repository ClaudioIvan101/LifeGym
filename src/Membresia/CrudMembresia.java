package Membresia;

import socio.Socio;
import socio.SocioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudMembresia {
    private final List<Membresia> lista = new ArrayList<>();
    private int nextId = 1;

    public Membresia agregar(String nombre, double precio) {
        if (!esPrecioValido(precio)) {
            System.out.println("El precio debe ser mayor a cero.");
        }
        Membresia m = new Membresia(nextId++, nombre, precio);
        lista.add(m);
        return m;
    }

    public boolean modificar(int id, String nuevoNombre, double nuevoPrecio) {
        if (!esPrecioValido(nuevoPrecio)) {
            return false;
        }
        Membresia m = buscarPorId(id);
        if (m == null) return false;
        m.setNombre(nuevoNombre);
        m.setPrecio(nuevoPrecio);
        return true;
    }

    public boolean eliminar(int id) {
        boolean existe = lista.stream().anyMatch(m -> m.getId() == id);

        if (!existe) {
            System.out.println("No se encontró una membresía con el ID " + id);
            return false;
        }

        lista.removeIf(m -> m.getId() == id);
        System.out.println("Membresía con ID " + id + " eliminada correctamente.");
        return true;
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
    public static boolean esPrecioValido(double precio) {
        return precio > 0;
    }
}
