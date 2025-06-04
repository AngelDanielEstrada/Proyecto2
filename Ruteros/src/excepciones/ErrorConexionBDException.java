package excepciones;

public class ErrorConexionBDException extends RuntimeException {
    public ErrorConexionBDException(String mensaje) {
        super(mensaje);
    }

    public ErrorConexionBDException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
