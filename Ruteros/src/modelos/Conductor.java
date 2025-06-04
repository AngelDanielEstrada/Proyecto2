package modelo;

public class Conductor extends Usuario {

    public Conductor(int id, String nombre) {
        super(id, nombre);
    }

    /**
     * Cobra un viaje, validando que el pago haya sido procesado correctamente.
     */
    public void cobrarViaje(Viaje v) {
        if (v != null) {
            boolean pagado = v.getPago().procesarPago(v);
            if (pagado) {
                System.out.println("Pago procesado exitosamente para el viaje ID: " + v.getId());
            } else {
                throw new PagoNoConfirmadoException("No se pudo confirmar el pago del viaje.");
            }
        }
    }

    /**
     * Confirma que el pasajero pagó en efectivo.
     * Aquí puedes asumir que el conductor valida visualmente el pago.
     */
    public void confirmarPagoEfectivo(Viaje v) {
        if (v != null && v.getPago() instanceof PagoEnEfectivo) {
            System.out.println("Pago en efectivo confirmado para el viaje ID: " + v.getId());
        } else {
            throw new PagoNoConfirmadoException("El pago no es en efectivo o el viaje es inválido.");
        }
    }
}
