package modelo;

public class TokenWallet {
    private int saldo;

    public TokenWallet() {
        this.saldo = 0;
    }

    /**
     * Intenta pagar una cantidad de tokens.
     * Lanza una excepción si no hay saldo suficiente.
     */
    public void pagar(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a pagar debe ser positiva.");
        }
        if (saldo < cantidad) {
            throw new excepciones.SaldoInsuficienteException("Saldo insuficiente para realizar el pago.");
        }
        saldo -= cantidad;
        System.out.println("Pago de " + cantidad + " tokens realizado. Saldo restante: " + saldo);
    }

    /**
     * Recarga la wallet con una cantidad de tokens.
     */
    public void recargar(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a recargar debe ser positiva.");
        }
        saldo += cantidad;
        System.out.println("Recarga exitosa de " + cantidad + " tokens. Nuevo saldo: " + saldo);
    }

    /**
     * Devuelve el saldo actual.
     */
    public int consultarSaldo() {
        return saldo;
    }
}
