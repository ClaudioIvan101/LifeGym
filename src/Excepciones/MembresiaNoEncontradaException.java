package Excepciones;

public class MembresiaNoEncontradaException extends Exception{
    public MembresiaNoEncontradaException(int id) {
        super("No se encontró la membresía con ID " + id);
    }
}
