package socio;


import Membresia.Membresia;


public class Socio extends Persona{
    private Membresia membresia;
    private int idMembresia;

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Socio(int dni, String nombre, int edad) {
        super(dni, nombre, edad);
    }

    @Override
    public void mostrarInfo() {
    }

    // Getters y Setters necesarios
    public void setMembresia(Membresia membresia) { this.membresia = membresia; }
    public Membresia getMembresia() { return membresia; }
}