package Membresia;

import Excepciones.MembresiaNoEncontradaException;
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

    public boolean modificar(int id, String nuevoNombre, double nuevoPrecio) throws MembresiaNoEncontradaException {
        if (!esPrecioValido(nuevoPrecio)) {
            return false;
        }
        try {
            Membresia m = buscarPorId(id);
            m.setNombre(nuevoNombre);
            m.setPrecio(nuevoPrecio);
            return true;
        } catch (MembresiaNoEncontradaException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) throws MembresiaNoEncontradaException{
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

    public Membresia buscarPorId(int id) throws MembresiaNoEncontradaException {
        for (Membresia m : lista) {
            if (m.getId() == id) return m;
        }
        throw new MembresiaNoEncontradaException(id);
    }

    public static boolean esPrecioValido(double precio) {
        return precio > 0;
    }
}
