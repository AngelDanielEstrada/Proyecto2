package interfaces;

import modelo.Ruta;
import java.util.List;

public interface IRutaDAO {
    Ruta obtenerRutaPorId(int id);
    List<Ruta> obtenerTodasRutas();
    void insertarRuta(Ruta r);
}
