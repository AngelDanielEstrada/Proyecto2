package interfaces;

import modelo.Viaje;

public interface IPago {
    boolean procesarPago(Viaje viaje);
}
