package modelo;

public class AdminSistema extends Usuario {

    public AdminSistema(int id, String nombre) {
        super(id, nombre);
    }

    /**
     * Muestra estadísticas del sistema.
     * Este método puede ser reemplazado más adelante por lógica real que consulte la base de datos o procesamientos.
     */
    public void verEstadisticas() {
        System.out.println("Mostrando estadísticas del sistema...");
        // Ejemplo de estadísticas simuladas
        System.out.println("- Total de usuarios: [por implementar]");
        System.out.println("- Total de viajes realizados: [por implementar]");
        System.out.println("- Tokens circulantes: [por implementar]");
    }
}
