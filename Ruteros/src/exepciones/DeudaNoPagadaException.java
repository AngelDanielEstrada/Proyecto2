package excepciones;

public class DeudaNoPagadaException extends RuntimeException {
    public DeudaNoPagadaException(String mensaje) {
        super(mensaje);
    }
}
