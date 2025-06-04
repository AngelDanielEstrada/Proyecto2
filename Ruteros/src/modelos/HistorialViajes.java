package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistorialViajes {
    private List<Viaje> viajes;

    public HistorialViajes() {
        this.viajes = new ArrayList<>();
    }

    // Agregar un viaje al historial
    public void agregarViaje(Viaje viaje) {
        if (viaje != null && viaje.getEstado() == Viaje.EstadoViaje.COMPLETADO) {
            viajes.add(viaje);
        }
    }

    // Obtener todos los viajes
    public List<Viaje> obtenerViajes() {
        return new ArrayList<>(viajes); // Devuelve copia para proteger encapsulamiento
    }

    // Obtener viajes por estado
    public List<Viaje> obtenerViajesPorEstado(Viaje.EstadoViaje estado) {
        return viajes.stream()
                .filter(v -> v.getEstado() == estado)
                .collect(Collectors.toList());
    }

    // Obtener el costo total de todos los viajes
    public double obtenerCostoTotal() {
        return viajes.stream()
                .mapToDouble(Viaje::getCosto)
                .sum();
    }

    // Obtener viajes recientes (últimos N)
    public List<Viaje> obtenerViajesRecientes(int cantidad) {
        int fromIndex = Math.max(viajes.size() - cantidad, 0);
        return new ArrayList<>(viajes.subList(fromIndex, viajes.size()));
    }

    // Método para limpiar historial
    public void limpiarHistorial() {
        viajes.clear();
    }
}