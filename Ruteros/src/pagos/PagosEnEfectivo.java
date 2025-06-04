package pagos;

import modelos.Viaje;
import modelos.Conductor;
import pagos.exceptions.PagoNoConfirmadoException;

/**
 * Implementación de pago en efectivo que requiere confirmación manual
 */
public class PagoEnEfectivo implements IPago {
    private boolean confirmado;
    private String referenciaPago;

    public PagoEnEfectivo() {
        this.confirmado = false;
        this.referenciaPago = null;
    }

    @Override
    public boolean procesarPago(Viaje viaje) throws PagoException {
        validarViaje(viaje);
        validarConductor(viaje.getConductor());

        if (!confirmado) {
            throw new PagoNoConfirmadoException("El conductor no ha confirmado el pago");
        }

        registrarTransaccion(viaje);
        return true;
    }

    @Override
    public String getTipoPago() {
        return "Pago en Efectivo";
    }

    /**
     * Confirma el pago en efectivo
     * @param referencia Número de comprobante o referencia
     */
    public void confirmarPago(String referencia) {
        this.confirmado = true;
        this.referenciaPago = referencia;
    }

    /**
     * Cancela la confirmación del pago
     */
    public void cancelarConfirmacion() {
        this.confirmado = false;
        this.referenciaPago = null;
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }

    private void validarViaje(Viaje viaje) throws PagoNoConfirmadoException {
        if (viaje == null) {
            throw new PagoNoConfirmadoException("El viaje no puede ser nulo");
        }
    }

    private void validarConductor(Conductor conductor) throws PagoNoConfirmadoException {
        if (conductor == null) {
            throw new PagoNoConfirmadoException("Conductor no asignado");
        }
    }

    private void registrarTransaccion(Viaje viaje) {
        System.out.printf("Pago en efectivo confirmado: $%.2f por %s. Referencia: %s%n",
                viaje.getCosto(), viaje.getPasajero().getNombre(), referenciaPago);
    }
}