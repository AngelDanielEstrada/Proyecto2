package pagos;

import modelo.Viaje;
import modelo.Pasajero;
import pagos.exceptions.SaldoInsuficienteException;
import pagos.exceptions.PagoNoConfirmadoException;

/**
 * Implementación de pago usando tokens del sistema
 */
public class PagoConTokens implements IPago {
    private static final double TASA_CONVERSION = 1.0; // 1 token = $1

    @Override
    public boolean procesarPago(Viaje viaje) throws PagoException {
        validarViaje(viaje);

        Pasajero pasajero = viaje.getPasajero();
        validarPasajero(pasajero);

        int tokensRequeridos = calcularTokens(viaje.getCosto());

        try {
            pasajero.getWallet().pagar(tokensRequeridos);
            registrarTransaccion(pasajero, tokensRequeridos);
            return true;
        } catch (SaldoInsuficienteException e) {
            throw new PagoNoConfirmadoException("Saldo insuficiente de tokens", e);
        }
    }

    @Override
    public String getTipoPago() {
        return "Pago con Tokens";
    }

    private int calcularTokens(double costo) {
        return (int) Math.ceil(costo * TASA_CONVERSION);
    }

    private void validarViaje(Viaje viaje) throws PagoNoConfirmadoException {
        if (viaje == null) {
            throw new PagoNoConfirmadoException("El viaje no puede ser nulo");
        }
    }

    private void validarPasajero(Pasajero pasajero) throws PagoNoConfirmadoException {
        if (pasajero == null) {
            throw new PagoNoConfirmadoException("Pasajero no asignado");
        }
        if (pasajero.getWallet() == null) {
            throw new PagoNoConfirmadoException("El pasajero no tiene wallet configurada");
        }
    }

    private void registrarTransaccion(Pasajero pasajero, int tokens) {
        System.out.printf("Transacción exitosa: %d tokens debitados de %s. Saldo restante: %d%n",
                tokens, pasajero.getNombre(), pasajero.getWallet().consultarSaldo());
    }
}