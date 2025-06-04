package interfaces;

import java.sql.Connection;

public interface IConexionBD {
    Connection conectar();
    void cerrar();
}
