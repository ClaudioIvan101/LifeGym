package Asistencia;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Asistencia {

    private int id;
    private Socio socio;
    private LocalDateTime fechaHora;
    private Membresia membresia;

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public Asistencia(int id, Socio socio, LocalDateTime fechaHora, Membresia membresia) {
        this.id = id;
        this.socio = socio;
        this.fechaHora = fechaHora;
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "id=" + id +
                ", socio=" + socio +
                ", fechaHora=" + fechaHora +
                ", membresia=" + membresia +
                '}';
    }

}

