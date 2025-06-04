package excepciones;

public class RutaNoEncontradaException extends RuntimeException {
    public RutaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
