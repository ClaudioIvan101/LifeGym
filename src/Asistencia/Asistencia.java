package Asistencia;

import Membresia.Membresia;
import socio.Socio;

import java.time.LocalDateTime;

public class Asistencia {
    private Socio socio;
    private Membresia membresia;
    private LocalDateTime fechaHora;
    private int id;

    public Asistencia(Socio socio, Membresia membresia, LocalDateTime fechaHora, int id) {
        this.socio = socio;
        this.membresia = membresia;
        this.fechaHora = fechaHora;
        this.id = id;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "socio=" + socio +
                ", membresia=" + membresia +
                ", fechaHora=" + fechaHora +
                ", id=" + id +
                '}';
    }
}
