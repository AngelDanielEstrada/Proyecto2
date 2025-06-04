package modelo;

import java.time.LocalDateTime;
import java.time.Duration;

public class Viaje {
    private int id;
    private Pasajero pasajero;
    private Conductor conductor;
    private Ruta ruta;
    private IPago metodoPago;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private EstadoViaje estado;
    private double costo;

    public enum EstadoViaje {
        PENDIENTE, EN_CURSO, COMPLETADO, CANCELADO
    }

    // Constructor
    public Viaje(int id, Pasajero pasajero, Ruta ruta, IPago metodoPago) {
        this.id = id;
        this.pasajero = pasajero;
        this.ruta = ruta;
        this.metodoPago = metodoPago;
        this.estado = EstadoViaje.PENDIENTE;
    }

    // Método para iniciar el viaje
    public void iniciarViaje(Conductor conductor) {
        this.conductor = conductor;
        this.fechaHoraInicio = LocalDateTime.now();
        this.estado = EstadoViaje.EN_CURSO;
    }

    // Método para finalizar el viaje
    public void finalizarViaje() {
        this.fechaHoraFin = LocalDateTime.now();
        this.estado = EstadoViaje.COMPLETADO;
        this.calcularCosto();
        this.procesarPago();
    }

    private void calcularCosto() {
        // Lógica para calcular costo basado en distancia, tiempo, etc.
        // Esto es un ejemplo simple
        Duration duracion = Duration.between(fechaHoraInicio, fechaHoraFin);
        long minutos = duracion.toMinutes();
        this.costo = minutos * 0.5; // $0.5 por minuto
    }

    private void procesarPago() {
        boolean pagoExitoso = metodoPago.procesarPago(this);
        if (!pagoExitoso) {
            throw new PagoNoConfirmadoException("El pago no pudo ser procesado");
        }
    }

    // Getters
    public int getId() { return id; }
    public Pasajero getPasajero() { return pasajero; }
    public Conductor getConductor() { return conductor; }
    public Ruta getRuta() { return ruta; }
    public EstadoViaje getEstado() { return estado; }
    public double getCosto() { return costo; }
    public LocalDateTime getFechaHoraInicio() { return fechaHoraInicio; }
    public LocalDateTime getFechaHoraFin() { return fechaHoraFin; }

    @Override
    public String toString() {
        return "Viaje{" +
                "id=" + id +
                ", ruta=" + ruta.getNombre() +
                ", estado=" + estado +
                ", costo=" + costo +
                '}';
    }
}