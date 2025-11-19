package socio;


import membresia.Membresia;
import persona.Persona;

public class Socio extends Persona {
    private int nroSocio;
    private Membresia membresia;

    public Socio(String nombre, String dni, String email, int nroSocio, Membresia membresia) {
        super(nombre, dni, email);
        this.nroSocio = nroSocio;
        this.membresia = membresia;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Socio #" + nroSocio + " | " + nombre + " | Plan: " + membresia);
    }

    // Getters y Setters necesarios
    public int getNroSocio() { return nroSocio; }
    public void setMembresia(Membresia membresia) { this.membresia = membresia; }
    public Membresia getMembresia() { return membresia; }
}