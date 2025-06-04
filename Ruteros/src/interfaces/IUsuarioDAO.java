package interfaces;

import modelo.Usuario;

public interface IUsuarioDAO {
    Usuario obtenerUsuarioPorId(int id);
    void insertarUsuario(Usuario u);
}
