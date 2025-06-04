package excepciones;

public class PagoNoConfirmadoException extends RuntimeException {
    public PagoNoConfirmadoException(String mensaje) {
        super(mensaje);
    }
}
