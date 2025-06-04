package pagos;

import pagos.exceptions.SaldoInsuficienteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la cartera de tokens de un usuario
 */
public class TokenWallet {
    private int saldo;
    private List<String> transacciones;

    public TokenWallet(int saldoInicial) {
        this.saldo = saldoInicial;
        this.transacciones = new ArrayList<>();
        registrarTransaccion("Creación de wallet con saldo inicial: " + saldoInicial);
    }

    /**
     * Realiza un pago con tokens
     * @param cantidad Tokens a pagar
     * @throws SaldoInsuficienteException Si no hay saldo suficiente
     */
    public synchronized void pagar(int cantidad) throws SaldoInsuficienteException {
        validarCantidad(cantidad);

        if (saldo < cantidad) {
            throw new SaldoInsuficienteException(
                    String.format("Saldo insuficiente. Disponible: %d, Requerido: %d", saldo, cantidad));
        }

        saldo -= cantidad;
        registrarTransaccion("Pago realizado: -" + cantidad + " tokens");
    }

    /**
     * Recarga tokens en la wallet
     * @param cantidad Tokens a recargar
     */
    public synchronized void recargar(int cantidad) {
        validarCantidad(cantidad);
        saldo += cantidad;
        registrarTransaccion("Recarga realizada: +" + cantidad + " tokens");
    }

    /**
     * @return Saldo actual de tokens
     */
    public int consultarSaldo() {
        return saldo;
    }

    /**
     * @return Historial de transacciones
     */
    public List<String> getTransacciones() {
        return new ArrayList<>(transacciones);
    }

    private void validarCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
    }

    private void registrarTransaccion(String descripcion) {
        String transaccion = String.format("[%s] %s. Saldo: %d",
                java.time.LocalDateTime.now(), descripcion, saldo);
        transacciones.add(transaccion);
    }

    @Override
    public String toString() {
        return String.format("TokenWallet{saldo=%d, transacciones=%d}", saldo, transacciones.size());
    }
}